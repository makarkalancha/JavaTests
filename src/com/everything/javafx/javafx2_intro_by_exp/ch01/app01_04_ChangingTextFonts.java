package com.everything.javafx.javafx2_intro_by_exp.ch01;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by mcalancea on 2016-02-12.
 */
public class app01_04_ChangingTextFonts extends Application {

    private static final String JAVA_FX = "JavaFX 2.0: Intro. by Example";
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 1-4 Changing Text Fonts");
        Group root = new Group();
        Scene scene = new Scene(root, 550, 250, Color.WHITE);

        //Serif with drop shadow
        Text text1 = new Text(50, 50, JAVA_FX);
        Font serif = Font.font("Serif", 30);
        text1.setFont(serif);
        text1.setFill(Color.RED);
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0f);
        dropShadow.setOffsetY(2.0f);
        dropShadow.setColor(Color.rgb(50, 50, 50, .588));
        text1.setEffect(dropShadow);
        root.getChildren().add(text1);

        //SanSerif
        Text text2 = new Text(50, 100, JAVA_FX);
        Font sanSerif = Font.font("SanSerif", 30);
        text2.setFont(sanSerif);
        text2.setFill(Color.BLUE);
        root.getChildren().add(text2);

        //Dialog
        Text text3 = new Text(50, 150, JAVA_FX);
        Font dialogFont = Font.font("Dialog", 30);
        text3.setFont(dialogFont);
        text3.setFill(Color.rgb(0, 255, 0));
        root.getChildren().add(text3);

        //Monospaced
        Text text4 = new Text(50, 200, JAVA_FX);
        Font monoFont = Font.font("Monospaced", 30);
        text4.setFont(monoFont);
        text4.setFill(Color.BLACK);
        root.getChildren().add(text4);

        Reflection reflection = new Reflection();
        reflection.setFraction(0.8f);
        text4.setEffect(reflection);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
