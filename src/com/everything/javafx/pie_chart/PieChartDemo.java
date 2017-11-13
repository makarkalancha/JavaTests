package com.everything.javafx.pie_chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.CssMetaData;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by mcalancea
 * Date: 13 Nov 2017
 * Time: 14:39
 */
public class PieChartDemo extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
//                        new PieChart.Data("Grapefruit", 13),
//                        new PieChart.Data("Oranges", 25),
//                        new PieChart.Data("Plums", 10),
//                        new PieChart.Data("Pears", 22),
//                        new PieChart.Data("Apples", 30));
                new PieChart.Data("Grapefruit", 1),
                new PieChart.Data("Oranges", 2),
                new PieChart.Data("Plums", 3),
                new PieChart.Data("Pears", 4),
                new PieChart.Data("Apples", 5));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");

        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");

//        for (final PieChart.Data data : chart.getData()) {
//            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
//                    new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent e) {
//                            caption.setTranslateX(e.getSceneX());
//                            caption.setTranslateY(e.getSceneY());
//                            caption.setText(String.valueOf(data.getPieValue()) + "%");
//                            System.out.println("x: "+e.getScreenX());
//                            System.out.println("y: "+e.getScreenY());
//                            System.out.println("data.name: "+data.getName());
//                            System.out.println("data.value: "+data.getPieValue());
//                        }
//                    });
//        }
        for (int i = 0; i < chart.getData().size(); i++) {
            final PieChart.Data data = chart.getData().get(i);
            final int index = i;
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                            System.out.println("x: " + e.getScreenX());
                            System.out.println("y: " + e.getScreenY());
                            System.out.println("data.name: " + data.getName());
                            System.out.println("data.value: " + data.getPieValue());
                            System.out.println("data.node: " + data.getNode().lookupAll(String.format(".default-color%d.chart-pie", index)));
                            String style = data.getNode().getStyleClass().stream().filter(s -> s.startsWith("default-color")).findFirst().orElse(null);
                            System.out.println(style);
                            CssMetaData value = data.getNode().getCssMetaData().stream()
                                    .filter(p -> p.getProperty().equals(style))
                                    .findFirst()
                                    .orElse(null);
                            System.out.println(value);
                            data.getNode().getCssMetaData().forEach(System.out::println);
                            https://stackoverflow.com/questions/25186238/constant-colors-on-a-piechart

                            reverse color
                            https://stackoverflow.com/questions/4672271/reverse-opposing-colors
                        }
                    });
        }

        ((Group) scene.getRoot()).getChildren().addAll(chart, caption);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
