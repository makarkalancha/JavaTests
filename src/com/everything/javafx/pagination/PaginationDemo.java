package com.everything.javafx.pagination;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Makar Kalancha
 * Date: 15 Nov 2016
 * Time: 08:41
 */
public class PaginationDemo extends Application{
    private Pagination pagination;
    private int totalPages = 28;

    public static void main(String[] args) throws Exception{
        launch(args);
    }

    public int itemsPerPage(){
        return 8;
    }

    public VBox createPage(int pageIndex){
        VBox vBox = new VBox(5);
        int page = pageIndex * itemsPerPage();
        for (int i = page; i < page + itemsPerPage(); i++) {
            VBox elemnt = new VBox();
            Hyperlink link = new Hyperlink("Item " + (i + 1));
            link.setVisited(true);
            Label text = new Label("Search results\nfor " + link.getText());
            elemnt.getChildren().addAll(link, text);

            vBox.getChildren().add(elemnt);
        }

        return vBox;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        pagination = new Pagination(totalPages, 0);
        pagination.setStyle("-fx-border-color: red");
        pagination.setPageFactory(param -> {
            if(param >= totalPages){
                return null;
            }else {
                return createPage(param);
            }
        });

        AnchorPane anchorPane = new AnchorPane();
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 10.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        anchorPane.getChildren().addAll(pagination);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pagination Demo");
        primaryStage.show();


    }
}
