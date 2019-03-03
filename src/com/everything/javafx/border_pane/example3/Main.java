package com.everything.javafx.border_pane.example3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * User: Makar Kalancha
 * Date: 24/09/2017
 * Time: 01:34
 * http://physalix.com/javafx2-borderpane-which-slides-in-and-out-on-command/
 */
public class Main extends Application {

    private static final String STYLESHEET_PATH = "/styles.css";

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        scene.getStylesheets().add(STYLESHEET_PATH);
        stage.setTitle("Table View Favorite Sample");
        stage.setWidth(600);
        stage.setHeight(431);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(431);
        anchorPane.setPrefWidth(600);

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefHeight(400.0);
        borderPane.setPrefWidth(600.0);
        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane, 0.0);
        AnchorPane.setTopAnchor(borderPane, 31.0);

        ToolBar toolbar = new ToolBar();
        toolbar.setPrefWidth(600.0);
        AnchorPane.setTopAnchor(toolbar, 0.0);
        AnchorPane.setLeftAnchor(toolbar, 0.0);
        AnchorPane.setRightAnchor(toolbar, 0.0);

        Button buttonTop = new Button("Top");
        Label labelTop = new Label("Top");

        Button buttonLeft = new Button("Left");
        Label labelLeft = new Label("Left");

        Button buttonBottom = new Button("Bottom");
        Label labelBottom = new Label("Bottom");

        Button buttonRight = new Button("Right");
        Label labelRight = new Label("Right");

        Label labelCenter = new Label("Center");

        /**
         * Instanciate a BorderSlideBar for each childs layouts
         */
        BorderSlideBar topFlapBar = new BorderSlideBar(Color.RED, 100, /*buttonTop,*/ Position.TOP, new VBox(labelTop));
        buttonTop.setOnAction(event -> topFlapBar.handle(event));
        borderPane.setTop(topFlapBar);

        BorderSlideBar leftFlapBar = new BorderSlideBar(Color.GREEN, 100, /*buttonLeft,*/ Position.LEFT, new VBox(labelLeft));
        buttonLeft.setOnAction(event -> leftFlapBar.handle(event));
        borderPane.setLeft(leftFlapBar);

        BorderSlideBar bottomFlapBar = new BorderSlideBar(Color.BLUE, 100, /*buttonBottom,*/ Position.BOTTOM, new VBox(labelBottom));
        buttonBottom.setOnAction(event -> bottomFlapBar.handle(event));
        borderPane.setBottom(bottomFlapBar);

        BorderSlideBar rightFlapBar = new BorderSlideBar(Color.YELLOW, 100, /*buttonRight,*/ Position.RIGHT, new VBox(labelRight));
        buttonRight.setOnAction(event -> rightFlapBar.handle(event));
        borderPane.setRight(rightFlapBar);

        VBox centerVbox = new VBox();
        centerVbox.setBackground(new Background(new BackgroundFill(Color.YELLOWGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        centerVbox.getChildren().addAll(labelCenter);
//        Color.YELLOWGREEN, 100, null, Pos.CENTER, labelCenter
        borderPane.setCenter(centerVbox);

        toolbar.getItems().addAll(buttonTop, buttonLeft, buttonBottom, buttonRight);

        anchorPane.getChildren().addAll(borderPane, toolbar);

        ((Group) scene.getRoot()).getChildren().addAll(anchorPane);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}