package com.everything.javafx.linechart;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * Created by Makar Kalancha
 * Date: 17 May 2017
 * Time: 12:24
 */
public class GraphTestXAxisNumber extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Stock Monitoring, 2010");

        //defining a series
        XYChart.Series<Number, Number> series1 = new XYChart.Series();
        series1.setName("My portfolio 1");
        //populating the series with data
        series1.getData().add(new XYChart.Data(8, 45));
        series1.getData().add(new XYChart.Data(9, 43));
        series1.getData().add(new XYChart.Data(10, 17));
        series1.getData().add(new XYChart.Data(11, 29));
        series1.getData().add(new XYChart.Data(12, 25));
        series1.getData().add(new XYChart.Data(1, 23));
        series1.getData().add(new XYChart.Data(2, 14));
        series1.getData().add(new XYChart.Data(3, 15));
        series1.getData().add(new XYChart.Data(4, 24));
        series1.getData().add(new XYChart.Data(5, 34));
        series1.getData().add(new XYChart.Data(6, 36));
        series1.getData().add(new XYChart.Data(7, 22));

        //defining a series
        XYChart.Series<Number, Number> series2 = new XYChart.Series();
        series2.setName("My portfolio 2");
        //populating the series with data
        series2.getData().add(new XYChart.Data(1, 45));
        series2.getData().add(new XYChart.Data(14, 43));
        series2.getData().add(new XYChart.Data(15, 17));
        series2.getData().add(new XYChart.Data(16, 29));
        series2.getData().add(new XYChart.Data(17, 25));
        series2.getData().add(new XYChart.Data(18, 23));
        series2.getData().add(new XYChart.Data(19, 14));
        series2.getData().add(new XYChart.Data(20, 15));
        series2.getData().add(new XYChart.Data(21, 24));
        series2.getData().add(new XYChart.Data(22, 34));
        series2.getData().add(new XYChart.Data(23, 36));
        series2.getData().add(new XYChart.Data(24, 22));

        lineChart.getData().add(series2);
        lineChart.getData().add(series1);

        Scene scene = new Scene(lineChart, 800, 600);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
