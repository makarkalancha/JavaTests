package com.everything.javafx.listview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Makar Kalancha
 * Date: 08 Sep 2017
 * Time: 09:51
 */
public class ListViewDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception{
//        ObservableList<CategoryRow> tasks = FXCollections.observableArrayList();
//        for(String string : taskNames){
//            tasks.add(new CategoryRow(string));
//        }

        ObservableList<String> tasks = FXCollections.observableArrayList(taskNames);

        ListView<String> reactionLog = new ListView<>(tasks);
        reactionLog.setCellFactory(param -> new CategoryRow());

        ListView<String> checklist = new ListView<>(tasks);
        checklist.setCellFactory(param -> new CategoryRow());
//        checklist.setCellFactory(CheckBoxListCell.forListView(Task::selectedProperty, new StringConverter<Task>() {
//            @Override
//            public String toString(Task object) {
//                return object.getName();
//            }
//
//            @Override
//            public Task fromString(String string) {
//                return null;
//            }
//        }));

        HBox layout = new HBox(10, checklist, reactionLog);
        layout.setPrefSize(350, 150);
        layout.setPadding(new Insets(10));
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static final String[] taskNames = {
            "Walk the dog-1",
            "Skin the cat-2",
            "Feed the pig-3",
            "Walk the dog-4",
            "Skin the cat-5",
            "Feed the pig-6",
            "Walk the dog-7",
            "Skin the cat-8",
            "Feed the pig-9",
            "Walk the dog-10",
            "Skin the cat-11",
            "Feed the pig-12",
            "Walk the dog-13",
            "Skin the cat-14",
            "Feed the pig-15"
    };

    //https://www.billmann.de/2013/07/03/javafx-custom-listcell/
    private class CategoryRow extends ListCell<String> {
        private final Button remove = new Button();
        private final Label categoryNameLbl = new Label();
        private final HBox hBox = new HBox();

        public CategoryRow() {
            hBox.setPadding(new Insets(3));
            hBox.setSpacing(5d);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.getChildren().addAll(remove, categoryNameLbl);

            remove.setOnAction(event -> {
                String categoryNameFromItem = getItem();
                System.out.println(">>>setOnAction remove text: " + categoryNameFromItem);
                System.out.println(">>>setOnAction remove idx: " + getIndex());
                getListView().getItems().remove(getIndex());

//                checklist.getItems().remove(getIndex());

            });
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
//            System.out.println(item);
            if (!StringUtils.isBlank(item) && !empty) {
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                categoryNameLbl.setText(item);
                setGraphic(hBox);
            } else {
                setGraphic(null);
                setText(null);
            }
        }
    }
}
