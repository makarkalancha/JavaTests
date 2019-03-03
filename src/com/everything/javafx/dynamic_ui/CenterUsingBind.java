package com.everything.javafx.dynamic_ui;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Created by Makar Kalancha
 * Date: 26 Sep 2017
 * Time: 08:52
 * http://what-when-how.com/javafx-2/dynamic-layout-techniques-building-dynamic-ui-layouts-in-javafx-part-1/
 */
public class CenterUsingBind extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text = new Text("java");
//        text.setTextOrigin(VPos.TOP);
        text.setTextOrigin(VPos.CENTER);
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFont(Font.font(null, FontWeight.BOLD, 18));

        Scene scene = new Scene(new Group(text), 400, 100);
//        text.layoutXProperty().bind(scene.widthProperty().subtract(text.prefWidth(-1)).divide(2));
//        text.layoutYProperty().bind(scene.heightProperty().subtract(text.prefHeight(-1)).divide(2));

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
