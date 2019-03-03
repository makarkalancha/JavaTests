package com.everything.javafx.linechart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Makar Kalancha
 * Date: 17 May 2017
 * Time: 12:24
 */
public class GraphTestXAxisString extends Application {
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes

        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<String, Number> lineChart
                = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");

        //defining a series
        XYChart.Series<String, Number> series1 = new XYChart.Series();
        series1.setName("My portfolio 1");
        //populating the series with data
        series1.getData().add(new XYChart.Data("8", 45));
        series1.getData().add(new XYChart.Data("9", 43));
        series1.getData().add(new XYChart.Data("10", 17));
        series1.getData().add(new XYChart.Data("11", 29));
        series1.getData().add(new XYChart.Data("12", 25));
        series1.getData().add(new XYChart.Data("1", 23));
        series1.getData().add(new XYChart.Data("2", 14));
        series1.getData().add(new XYChart.Data("3", 15));
        series1.getData().add(new XYChart.Data("4", 24));
        series1.getData().add(new XYChart.Data("5", 34));
        series1.getData().add(new XYChart.Data("6", 36));
        series1.getData().add(new XYChart.Data("7", 22));

        //defining a series
        XYChart.Series<String, Number> series2 = new XYChart.Series();
        series2.setName("My portfolio 2");
        //populating the series with data
        series2.getData().add(new XYChart.Data("1", 45));
        series2.getData().add(new XYChart.Data("14", 43));
        series2.getData().add(new XYChart.Data("15", 17));
        series2.getData().add(new XYChart.Data("16", 29));
        series2.getData().add(new XYChart.Data("17", 25));
        series2.getData().add(new XYChart.Data("18", 23));
        series2.getData().add(new XYChart.Data("19", 14));
        series2.getData().add(new XYChart.Data("20", 15));
        series2.getData().add(new XYChart.Data("21", 24));
        series2.getData().add(new XYChart.Data("22", 34));
        series2.getData().add(new XYChart.Data("23", 36));
        series2.getData().add(new XYChart.Data("24", 22));

//        lineChart.getData().add(series2);
//        lineChart.getData().add(series1);
        lineChart.getData().addAll(series2, series1);

        /////////////////////////////////////////////////
//        ObjectProperty<Point2D> mouseLocationInScene = new SimpleObjectProperty<>();
//
//        Tooltip tooltip = new Tooltip();
//
//        lineChart.addEventHandler(MouseEvent.MOUSE_MOVED, evt -> {
//            if (!tooltip.isShowing()) {
//                mouseLocationInScene.set(new Point2D(evt.getSceneX(), evt.getSceneY()));
//            }
//        });
//
//        tooltip.textProperty().bind(Bindings.createStringBinding(() -> {
//                    if (mouseLocationInScene.isNull().get()) {
//                        return "" ;
//                    }
//                    double xInXAxis = xAxis.sceneToLocal(mouseLocationInScene.get()).getX() ;
//                    String x = xAxis.getValueForDisplay(xInXAxis);
//                    double yInYAxis = yAxis.sceneToLocal(mouseLocationInScene.get()).getY() ;
//                    double y = yAxis.getValueForDisplay(yInYAxis).doubleValue() ;
//                    return String.format("[%s, %.3f]", x, y);
//                }, mouseLocationInScene, xAxis.startMarginProperty(), xAxis.endMarginProperty(),
//                yAxis.lowerBoundProperty(), yAxis.upperBoundProperty()));
//
//        Tooltip.install(lineChart, tooltip);
        /////////////////////////////////////////////////

        xAxis.setAutoRanging(true);
//        Set<String> xValues = new TreeSet<>(lineChart.getData().stream()
//                .flatMap(
//                        d -> d.getData().stream()
//                            .map(d1 -> d1.getXValue())
//                )
//                .collect(Collectors.toSet()));
        Set<String> xValues = new TreeSet<>(lineChart.getData().stream()
                .map(d1 -> d1.getData())
                .flatMap(d2 -> d2.stream())
                .map(d3 -> d3.getXValue())
                .collect(Collectors.toSet()));
        xAxis.setCategories(FXCollections.<String>observableArrayList(xValues));
        xAxis.invalidateRange(new ArrayList<>(xValues));


        Scene scene = new Scene(lineChart, 800, 600);

        stage.setScene(scene);
        stage.show();

        Set<String> strings = new TreeSet<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("10");
        strings.add("11");
        strings.add("12");
        strings.add("13");
        strings.add("14");
        strings.add("15");
        strings.add("4");
        strings.add("5");
        strings.add("6");
        strings.add("7");
        strings.add("8");
        strings.add("9");
        strings.add("16");
        strings.add("17");
        strings.add("18");
        strings.add("19");
        strings.add("20");
        System.out.println(strings);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
