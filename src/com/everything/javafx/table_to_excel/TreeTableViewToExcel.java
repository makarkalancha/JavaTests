package com.everything.javafx.table_to_excel;

import com.everything.javafx.table_to_excel.decorator.PersonDecorator;
import com.everything.javafx.table_to_excel.decorator.PersonDepartmentDecorator;
import com.everything.javafx.table_to_excel.decorator.PersonObjDecorator;
import com.everything.javafx.table_to_excel.decorator.PersonRootDecorator;
import com.everything.javafx.table_to_excel.pojo.Person;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Makar Kalancha
 * Date: 19 Oct 2017
 * Time: 11:48
 */
public class TreeTableViewToExcel extends Application{
    private TreeTableView<PersonDecorator> table = new TreeTableView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        final ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("Jacob", 1, new BigDecimal("100.01"), LocalDateTime.now().minusDays(1)),
                new Person("Isabella", 2, new BigDecimal("90.01"), LocalDateTime.now().minusDays(2)),
                new Person("Ethan", 3, new BigDecimal("80.01"), LocalDateTime.now().minusDays(3)),
                new Person("Emma", 4, new BigDecimal("70.01"), LocalDateTime.now().minusDays(4)),
                new Person("Michael", 5, new BigDecimal("60.01"), LocalDateTime.now().minusDays(5))
        );

        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(600);
        stage.setHeight(500);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        TreeTableColumn<PersonDecorator, Long> idCol = new TreeTableColumn<>("Id");
        idCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PersonDecorator,Long> param) ->
                        new ReadOnlyObjectWrapper<Long>(param.getValue().getValue().getId())
        );

        TreeTableColumn<PersonDecorator, String> rootNameCol = new TreeTableColumn<>("root");
        rootNameCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PersonDecorator, String> param) ->
                        new ReadOnlyObjectWrapper<String>(param.getValue().getValue().getRootName())
        );

        TreeTableColumn<PersonDecorator, String> deptNameCol = new TreeTableColumn<>("dept name");
        deptNameCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PersonDecorator, String> param) ->
                        new ReadOnlyObjectWrapper<String>(param.getValue().getValue().getDepartmentName())
        );

        TreeTableColumn<PersonDecorator, String> firstNameCol = new TreeTableColumn<>("First Name");
        firstNameCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PersonDecorator, String> param) ->
                        new ReadOnlyObjectWrapper<String>(param.getValue().getValue().getFirstName())
        );

        TreeTableColumn<PersonDecorator, Integer> ageCol = new TreeTableColumn("age");
        ageCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PersonDecorator, Integer> param) ->
                        new ReadOnlyObjectWrapper<Integer>(param.getValue().getValue().getAge())
        );

        TreeTableColumn<PersonDecorator, String> salaryCol = new TreeTableColumn("salary");
        salaryCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PersonDecorator, String> param) ->
                {
                    String result = null;
                    BigDecimal bigDecimal = param.getValue().getValue().getSalary();
                    if(bigDecimal != null) {
                        result = bigDecimal.toString();
                    }
                    return new ReadOnlyObjectWrapper<>(result);
                }
        );

        TreeTableColumn<PersonDecorator, LocalDateTime> startdateCol = new TreeTableColumn("startDate");
        startdateCol.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<PersonDecorator, LocalDateTime> param) ->
                        new ReadOnlyObjectWrapper<LocalDateTime>(param.getValue().getValue().getStartDate())
        );
        table.getColumns().addAll(idCol,rootNameCol, deptNameCol, firstNameCol, ageCol, salaryCol, startdateCol);

        table.setEditable(true);
        table.setRoot(null);

        final TreeItem<PersonDecorator> rootNode = new TreeItem<>(new PersonRootDecorator("All Persons"));
        rootNode.setExpanded(true);

        final TreeItem<PersonDecorator> dept1Node = new TreeItem<>(new PersonDepartmentDecorator(1L, "Main"));
        dept1Node.setExpanded(true);
        int i = 0;
        for (; i < 2 && i < data.size(); i++) {
            TreeItem<PersonDecorator> personNode = new TreeItem<>(new PersonObjDecorator(data.get(i)));
            dept1Node.getChildren().add(personNode);
        }

        final TreeItem<PersonDecorator> dept2Node = new TreeItem<>(new PersonDepartmentDecorator(2L, "Sales"));
        dept2Node.setExpanded(true);
        for (; i < 4 && i < data.size(); i++) {
            TreeItem<PersonDecorator> personNode = new TreeItem<>(new PersonObjDecorator(data.get(i)));
            dept2Node.getChildren().add(personNode);
        }

        final TreeItem<PersonDecorator> dept3Node = new TreeItem<>(new PersonDepartmentDecorator(3L, "Stock"));
        dept3Node.setExpanded(true);
        for (; i < 6 && i < data.size(); i++) {
            TreeItem<PersonDecorator> personNode = new TreeItem<>(new PersonObjDecorator(data.get(i)));
            dept3Node.getChildren().add(personNode);
        }

        //Adding tree items to the root
        rootNode.getChildren().addAll(dept1Node, dept2Node, dept3Node);

        table.setRoot(rootNode);

        addExportToTreeTableView(table);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    private void addExportToTreeTableView(TreeTableView table) throws Exception{
        final ContextMenu cm = new ContextMenu();
        final MenuItem export = new MenuItem("Export to excel");
        export.setOnAction(event -> {
            try {
                exportTableViewToExcelFile(table);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        cm.getItems().add(export);
        table.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.SECONDARY){
                    cm.show(table, event.getScreenX(), event.getScreenY());
                }
            }
        });
    }

    private void exportTableViewToExcelFile(/*ActionEvent event, */TreeTableView table) throws Exception{
        /*
https://stackoverflow.com/questions/46017483/javafx-export-tableview-to-excel-with-name-of-columns
<dependency>
    <groupId>org.apache.xmlbeans</groupId>
    <artifactId>xmlbeans</artifactId>
    <version>2.6.0</version>
</dependency>
<dependency>
    <groupId>dom4j</groupId>
    <artifactId>dom4j</artifactId>
    <version>1.6.1</version>
</dependency>
         */
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("table");

        ObservableList<TreeTableColumn> col = table.getColumns();
        List<String> columns = col.stream()
                .map(tableColumn -> tableColumn.getText().toString())
                .collect(Collectors.toList());

        Row header = sheet.createRow(0);
        for (int i = 0; i < columns.size(); i++) {
            header.createCell(i).setCellValue(columns.get(i));
        }

        CellStyle dateTime = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        dateTime.setDataFormat(
                creationHelper.createDataFormat().getFormat("yyyy-mm-dd h:mm:ss"));

        ObservableList<TreeTableColumn> treeTableColumns = table.getColumns();

        TreeItem rootNode = table.getRoot();
        ObservableList<TreeItem> level = rootNode.getChildren();
        long size = level.size()
                + level.stream()
                .mapToInt(treeItem -> treeItem.getChildren().size())
                .sum()
                + 1;
        for (int excelRowInx = 1, treeTableRowInx = 0; treeTableRowInx < size; excelRowInx++, treeTableRowInx++) {
            Row row = sheet.createRow(excelRowInx);
            for (int columnInx = 0; columnInx < table.getColumns().size(); columnInx++) {
                TreeTableColumn ttc = treeTableColumns.get(columnInx);
                Object valueObj = ttc.getCellData(treeTableRowInx);
                if (valueObj != null) {
                    Cell cell = row.createCell(columnInx);
                    if (valueObj instanceof Integer) {
                        cell.setCellValue((Integer) valueObj);
                    } else if (valueObj instanceof BigDecimal) {
                        cell.setCellValue(((BigDecimal) valueObj).doubleValue());
                    } else if (valueObj instanceof LocalDateTime) {
                        cell.setCellValue(Date.from(((LocalDateTime) valueObj).atZone(ZoneId.systemDefault()).toInstant()));
                        cell.setCellStyle(dateTime);
                    } else {
                        cell.setCellValue(valueObj.toString());
                    }
                }
            }
        }

        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save export");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Excel Workbook", "*.xlsx"),
                new FileChooser.ExtensionFilter("XLSX", "*.xlsx")
        );
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );

        File file = fileChooser.showSaveDialog(table.getScene().getWindow());
        if (file != null) {
            try{
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                workbook.write(fileOutputStream);
                fileOutputStream.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
