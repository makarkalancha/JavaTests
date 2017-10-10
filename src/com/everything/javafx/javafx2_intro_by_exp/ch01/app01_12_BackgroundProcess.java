package com.everything.javafx.javafx2_intro_by_exp.ch01;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by mcalancea on 2016-02-12.
 */
public class app01_12_BackgroundProcess extends Application {

    private static Task copyWorker;
    private final int numFiles = 30;

    public static void main(String[] args) {
        Application.launch(args);
    }

    public void copyFile(String src, String dst) throws InterruptedException {
        //simulate a long time
        Random rnd = new Random(System.currentTimeMillis());
        long millis = rnd.nextInt(1000);
        Thread.sleep(millis);
    }

    public Task createWorker(final int numFiles) {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < numFiles; i++) {
                    long elapsedTime = System.currentTimeMillis();
                    copyFile("some file", "some dest file");
                    elapsedTime = System.currentTimeMillis() - elapsedTime;
                    String status = elapsedTime + "milliseconds";

                    //queue up status
                    updateMessage(status);
                    updateProgress(i + 1, numFiles);
                }
                return true;
            }
        };
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 1-12 Background Process");
        Group root = new Group();
        Scene scene = new Scene(root, 330, 120, Color.WHITE);

        BorderPane mainPane = new BorderPane();
        mainPane.layoutXProperty().bind(scene.widthProperty().subtract(mainPane.widthProperty()).divide(2));

        root.getChildren().add(mainPane);

        final Label label = new Label("Files Transfer:");
        final ProgressBar progressBar = new ProgressBar(0);
        final ProgressIndicator progressIndicator = new ProgressIndicator(0);
        final HBox hBox = new HBox();
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(label, progressBar, progressIndicator);
        mainPane.setTop(hBox);

        final Button startBtn = new Button("Start");
        final Button cancelBtn = new Button("Cancel");
        final TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefSize(200, 70);
        final HBox hBox2 = new HBox();
        hBox2.setSpacing(5);
        hBox2.setAlignment(Pos.CENTER);
        hBox2.getChildren().addAll(startBtn, cancelBtn, textArea);
        mainPane.setBottom(hBox2);

        //wire up start button
        startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startBtn.setDisable(true);
                progressBar.setProgress(0);
                progressIndicator.setProgress(0);
                textArea.setText("");
                cancelBtn.setDisable(false);
                copyWorker = createWorker(numFiles);

                //wire up progress bar
                progressBar.progressProperty().unbind();
                progressBar.progressProperty().bind(copyWorker.progressProperty());
                progressIndicator.progressProperty().unbind();
                progressIndicator.progressProperty().bind(copyWorker.progressProperty());

                //append to text area
                copyWorker.messageProperty().addListener(new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        textArea.appendText(newValue + "\n");
                    }
                });

                new Thread(copyWorker).start();
            }
        });

        //cancel button will kill worker and reset
        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startBtn.setDisable(false);
                cancelBtn.setDisable(true);

                copyWorker.cancel(true);

                //reset
                progressBar.progressProperty().unbind();
                progressBar.setProgress(0);
                progressIndicator.progressProperty().unbind();
                progressIndicator.setProgress(0);
                textArea.setText("File transfer was cancelled.");
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }



}
