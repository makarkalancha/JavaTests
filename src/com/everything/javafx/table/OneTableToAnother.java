package com.everything.javafx.table;

import com.google.common.base.Objects;
import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
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

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Makar Kalancha
 * Date: 27/12/2017
 * Time: 16:27
 */
public class OneTableToAnother extends Application {
    private final ObservableList<String> data = FXCollections.observableArrayList(
            "text1",
            "text2",
            "text3",
            "text4",
            "text5"
    );
    private final TableView<BooleanTableRow<String>> table1 = new TableView<>();
    private final TableView<BooleanTableRow<String>> table2 = new TableView<>();

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
        table2.getColumns().addAll(text2Col);

        table1.setItems(BooleanTableRow.convertListIntoBooleanTableRowList(data, false));

        table2.itemsProperty().bindBidirectional(table1.itemsProperty());

        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 0, 0, 10));
        hbox.getChildren().addAll(table1, table2);

        ((Group) scene.getRoot()).getChildren().addAll(hbox);

        stage.setScene(scene);
        stage.show();
    }

    private static class BooleanTableRow<T> {
        private final T item;
        private boolean isChecked;

        public BooleanTableRow(T item, boolean isChecked) {
            this.item = item;
            this.isChecked = isChecked;
        }

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }

        public T getItem() {
            return item;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof BooleanTableRow){
                BooleanTableRow that = (BooleanTableRow) o;
                return Objects.equal(item, that.item)
                        && Objects.equal(isChecked, that.isChecked);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(item, isChecked);
        }

        public static <I> ObservableList<BooleanTableRow<I>> convertListIntoBooleanTableRowList(List<I> items, boolean isChecked){
            return FXCollections.observableArrayList(
                    items.stream()
                            .map(item -> new BooleanTableRow<I>(item, isChecked))
                            .collect(Collectors.toList())
            );
        }
    }
    
    private class IsPaidBooleanCell extends TableCell<BooleanTableRow<String>, Boolean> {
        private CheckBox checkBox;

        public IsPaidBooleanCell() {
            checkBox = new CheckBox();

            checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    BooleanTableRow<String> itemFilterTableRow = (BooleanTableRow<String>) getTableRow().getItem();
                    if(itemFilterTableRow != null) {
                        itemFilterTableRow.setChecked(newValue);
                        String text = itemFilterTableRow.getItem();
                        if(newValue) {
//                            table2.getItems().addAll(BooleanTableRow.convertListIntoBooleanTableRowList(Arrays.asList(text), false));
//                        if (newValue && !selectedIdToStringMap.containsKey(String.getId())) {
//                            selectStringFilterTableRow(String);
//                        } else if(!newValue && selectedIdToStringMap.containsKey(String.getId())){
//                            unselectStringFilterTableRow(String);
//                        }
//
//                        if (newValue && selectedIdToStringMap.containsKey(String.getId())) {
//                            getTableRow().setStyle(UserInterfaceConstants.CHART_TABLE_CHECKED_ROW);
//                        } else {
//                            getTableRow().setStyle("");
//                        }
                        }else if(!newValue){
//                            table2.getItems().remove(text);
                        }
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
