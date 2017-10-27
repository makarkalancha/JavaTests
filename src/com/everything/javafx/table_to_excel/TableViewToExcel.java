package com.everything.javafx.table_to_excel;

import com.everything.javafx.table_to_excel.pojo.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class TableViewToExcel extends Application{
    private TableView<Person> table = new TableView();

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
        stage.setWidth(300);
        stage.setHeight(500);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("firstName")
        );

        TableColumn ageCol = new TableColumn("age");
        ageCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("age")
        );

        TableColumn salaryCol = new TableColumn("salary");
        salaryCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("salary")
        );

        TableColumn startdateCol = new TableColumn("startDate");
        startdateCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("startDate")
        );
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, ageCol, salaryCol, startdateCol);

        addExportToTableView(table);
        table.getSelectionModel().selectedItemProperty().addListener((observable, oldSelection, newSelection) -> {
            if (newSelection != null && !newSelection.equals(oldSelection)){
                System.out.println("getSelectionModel");
            }
        });


        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
            }
        };
        table.addEventHandler(EventType.ROOT, event -> {
            System.out.println(event.getEventType());
        });

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    private void addExportToTableView(TableView table) throws Exception{
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

    private void exportTableViewToExcelFile(/*ActionEvent event, */TableView table) throws Exception{
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

        ObservableList<TableColumn> col = table.getColumns();
        List<String> columns = col.stream()
                .map(tableColumn -> ((TableColumn) tableColumn).getText().toString())
                .collect(Collectors.toList());

        Row header = sheet.createRow(0);
        for (int i = 0; i < columns.size(); i++) {
            header.createCell(i).setCellValue(columns.get(i));
        }

        CellStyle dateTime = workbook.createCellStyle();
        CreationHelper creationHelper = workbook.getCreationHelper();
        dateTime.setDataFormat(
                creationHelper.createDataFormat().getFormat("yyyy-mm-dd h:mm:ss"));

        for (int tableInx = 0, excelRowInx = 1; tableInx < table.getItems().size(); tableInx++, excelRowInx++) {
            Row row = sheet.createRow(excelRowInx);
            for (int columnInx = 0; columnInx < table.getColumns().size(); columnInx++) {
                Object valueObj = ((TableColumn) table.getColumns().get(columnInx)).getCellData(tableInx);
                if (valueObj != null) {
                    Cell cell = row.createCell(columnInx);
                    if (valueObj instanceof Integer) {
                        cell.setCellValue((Integer)valueObj);
                    }else if(valueObj instanceof BigDecimal){
                        cell.setCellValue(((BigDecimal)valueObj).doubleValue());
                    }else if(valueObj instanceof LocalDateTime){
                        cell.setCellValue(Date.from(((LocalDateTime) valueObj).atZone(ZoneId.systemDefault()).toInstant()));
                        cell.setCellStyle(dateTime);
                    }else {
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

//        File file = fileChooser.showSaveDialog(((Node)event.getTarget()).getScene().getWindow());
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
