package com.everything.javafx.javafx2_intro_by_exp.ch01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by mcalancea on 2016-02-12.
 */
public class app01_02_HelloWorldMain extends Application{
    private static final String HELLO_WORLD = "Hello World";
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(HELLO_WORLD);
        Group root = new Group();
        Scene scene = new Scene(root, 300, 500);
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText(HELLO_WORLD);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(HELLO_WORLD);
            }
        });
        root.getChildren().add(btn);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
