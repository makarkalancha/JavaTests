package com.everything.javafx.table_to_excel;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Makar Kalancha
 * Date: 19 Oct 2017
 * Time: 11:48
 */
public class TableViewToExcel extends Application{
    private TableView<Person> table = new TableView();
    private ContextMenu cm = new ContextMenu();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        final ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                new Person("Ethan", "Williams", "ethan.williams@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Michael", "Brown", "michael.brown@example.com")
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

        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("lastName")
        );

        TableColumn emailCol = new TableColumn("Email");
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("email")
        );
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        MenuItem export = new MenuItem("Export to excel");
        export.setOnAction(event -> {
            try {
                exportTableViewToExcelFile(stage, table);
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



        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    private void exportTableViewToExcelFile(Stage stage, TableView table) throws Exception{
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


        for (int tableInx = 0, excelRowInx = 1; tableInx < table.getItems().size(); tableInx++, excelRowInx++) {
            Row row = sheet.createRow(excelRowInx);
            for (int columnInx = 0; columnInx < table.getColumns().size(); columnInx++) {
                String value = ((TableColumn)table.getColumns().get(columnInx)).getCellData(tableInx).toString();
                if(!StringUtils.isBlank(value)) {
                    row.createCell(columnInx).setCellValue(value);
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

        File file = fileChooser.showSaveDialog(stage);
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
