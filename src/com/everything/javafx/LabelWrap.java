package com.everything.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Created by Makar Kalancha
 * Date: 19 Jun 2017
 * Time: 08:43
 */
public class LabelWrap extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label l1 = new Label("\t\tC-Mark and Attendance Calculator is a simple "
                + "software to find both the C-Mark and monthly attendance "
                + "of students. Inorder to use the features of this software,"
                + " user has to create an account for him first. Then he should "
                + "login using the username and password. He will be able to "
                + "perform all the operations then. Further details are mentioned"
                + " in the 'HELP' section in the user home page.");
        l1.setWrapText(true);
        l1.setTextAlignment(TextAlignment.JUSTIFY);

        StackPane root = new StackPane(l1);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}