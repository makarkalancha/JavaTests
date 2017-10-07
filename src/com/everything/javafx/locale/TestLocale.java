package com.everything.javafx.locale;/**
 * Created by mcalancea on 2016-04-19.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TestLocale extends Application {

    public static void main(String[] args) {
        System.setProperty("java.locale.providers", "HOST,SPI,JRE");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("calendar.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Calendar");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
