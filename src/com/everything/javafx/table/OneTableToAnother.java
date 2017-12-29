package com.everything.javafx.table;

import javafx.application.Application;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 27/12/2017
 * Time: 16:27
 */
public class OneTableToAnother extends Application {
    private final ObservableList<BooleanTableRow<String>> data = BooleanTableRow.convertListIntoBooleanTableRowList(
            FXCollections.observableArrayList("text1", "text2", "text3", "text4", "text5"), false
    );

    private Set<BooleanTableRow<String>> table1SetData = new LinkedHashSet<>();
//    private ObservableList<BooleanTableRow<String>> table1Data = FXCollections.observableArrayList();
    private Set<BooleanTableRow<String>> table2SetData = new LinkedHashSet<>();
//    private ObservableList<BooleanTableRow<String>> table2Data = FXCollections.observableArrayList();

    private final TableView<BooleanTableRow<String>> table1 = new TableView<>();
    private final TableView<BooleanTableRow<String>> table2 = new TableView<>();
    private ListProperty<BooleanTableRow<String>> listProperty1 = new SimpleListProperty<>();
    private ListProperty<BooleanTableRow<String>> listProperty2 = new SimpleListProperty<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(550);
        stage.setHeight(500);

        TableColumn<BooleanTableRow<String>, String> text1Col = new TableColumn("text");
        text1Col.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getItem()));

        TableColumn<BooleanTableRow<String>, Boolean> check1Col = new TableColumn("check");
        check1Col.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue() != null));
        check1Col.setCellFactory(param -> new IsPaidBooleanCell());
        table1.getColumns().addAll(check1Col, text1Col);

        TableColumn<BooleanTableRow<String>, String> text2Col = new TableColumn("text");
        text2Col.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getItem()));

        TableColumn<BooleanTableRow<String>, Boolean> check2Col = new TableColumn("check");
        check2Col.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue() != null));
        check2Col.setCellFactory(param -> new IsPaidBooleanCell());
        table2.getColumns().addAll(check2Col, text2Col);

        table1SetData.addAll(data);
        listProperty1.set(data);
//        table1Data.addAll(data);

//        listProperty2.set(table2Data);

        table1.itemsProperty().bind(listProperty1);
        table2.itemsProperty().bind(listProperty2);

//        table2.itemsProperty().bindBidirectional(table1.itemsProperty());

        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 0, 0, 10));
        hbox.getChildren().addAll(table1, table2);

        ((Group) scene.getRoot()).getChildren().addAll(hbox);

        stage.setScene(scene);
        stage.show();
    }

    private class IsPaidBooleanCell extends TableCell<BooleanTableRow<String>, Boolean> {
        private CheckBox checkBox;

        public IsPaidBooleanCell() {
            this.checkBox = new CheckBox();

            this.checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    System.out.println("table items:" + getTableRow().getTableView().getItems());
                    BooleanTableRow<String> itemFilterTableRow = (BooleanTableRow<String>) getTableRow().getItem();
                    if(itemFilterTableRow != null) {

//                        String text = itemFilterTableRow.getItem();
//                        System.out.println(text + ": " + oldValue + "; " + newValue);
                        if(newValue && table1SetData.contains(itemFilterTableRow)) {
                            boolean resultRemove1 = table1SetData.remove(itemFilterTableRow);

                            itemFilterTableRow.setChecked(newValue);
                            table2SetData.add(itemFilterTableRow);
                            listProperty1.set(FXCollections.observableArrayList(table1SetData));
                            listProperty2.set(FXCollections.observableArrayList(table2SetData));

                            System.out.println("resultRemove1:" + resultRemove1);
                        }else if(!newValue && table2SetData.contains(itemFilterTableRow)){
                            boolean resultRemove2 = table2SetData.remove(itemFilterTableRow);

                            itemFilterTableRow.setChecked(newValue);
                            table1SetData.add(itemFilterTableRow);
                            listProperty1.set(FXCollections.observableArrayList(table1SetData));
                            listProperty2.set(FXCollections.observableArrayList(table2SetData));

                            System.out.println("resultRemove2:" + resultRemove2);
                        }

//                        System.out.println("table1SetData:" + table1SetData);
//                        System.out.println("table2SetData:" + table2SetData);
                        System.out.println("=====================================");
                    } else {
                        getTableRow().setStyle("");
                    }
//                    setTextInSelectedSumAccountBalanceText();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }

        @Override
        protected void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);

            if(getTableRow() != null) {
                if (item == null || empty) {
                    setGraphic(null);
                    getTableRow().setStyle("");
                } else {
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

                    final BooleanTableRow<String> itemFilterTableRow = (BooleanTableRow<String>) getTableRow().getItem();
                    checkBox.setSelected(itemFilterTableRow == null ? false : itemFilterTableRow.isChecked());

                    this.setGraphic(checkBox);
                    this.setEditable(true);
                }
            }
        }
    }
}
