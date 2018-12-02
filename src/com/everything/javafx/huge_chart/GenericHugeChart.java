package com.everything.javafx.huge_chart;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.impl.CoordinateArraySequence;
import com.vividsolutions.jts.simplify.DouglasPeuckerSimplifier;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makar Kalancha
 * Date: 03 Oct 2017
 * Time: 09:41
 */
public abstract class GenericHugeChart<V extends Number> extends Application {
    private long t0;
    private long t1;
    private long t2;

    private static final int MAX_POINTS = 400;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Axis xAxis1 = new CategoryAxis();
        Axis yAxis1 = new NumberAxis();
        LineChart<String, V> graph1 = new LineChart<>(xAxis1, yAxis1);
        graph1.setAnimated(false);
        graph1.setCreateSymbols(false);
        graph1.setLegendVisible(false);
        XYChart.Series<String, V> series1 = new XYChart.Series<>();
        stage.setScene(new Scene(graph1));

        List<XYChart.Data<String, V>> data = fillData();
        ObservableList<XYChart.Data<String, V>> list = update1(data);
//        ObservableList<XYChart.Data<String, V>> list = huge(data);
        series1.setData(list);
        graph1.getData().add(series1);

        stage.show();

        t2 = System.nanoTime();
//        System.out.println(String.format("Total time reduces points from %d to %d in %.1f ms", coordinates.length, list.size(), (t2 - t0) / 1e6));
        System.out.println(String.format("Total time reduces points from %d to %d in %.1f ms", data.size(), list.size(), (t2 - t0) / 1e6));
    }

    public abstract List<XYChart.Data<String, V>> fillData();

    public abstract V convertDoubleToV(double d);


    //    private <V extends Number> ObservableList<XYChart.Data<String, V>> update1(List<XYChart.Data<String, V>> data){
    private ObservableList<XYChart.Data<String, V>> update(List<XYChart.Data<String, V>> data) {
        Coordinate[] coordinates = new Coordinate[data.size()];
        for (int i = 0; i < data.size(); i++) {
            coordinates[i] = new Coordinate(i, data.get(i).getYValue().doubleValue());
        }

        GeometryFactory gf = new GeometryFactory();
        Geometry geom = new LineString(new CoordinateArraySequence(coordinates), gf);
        Geometry simplified = DouglasPeuckerSimplifier.simplify(geom, 0.00001);
        List<XYChart.Data<String, V>> update = new ArrayList<XYChart.Data<String, V>>();
        for (Coordinate each : simplified.getCoordinates()) {
            update.add(new XYChart.Data<>(data.get((int) each.x).getXValue(), convertDoubleToV(each.y)));
        }
        t1 = System.nanoTime();

        System.out.println(String.format("Reduces points from %d to %d in %.1f ms", data.size(), update.size(), (t1 - t0) / 1e6));
        return FXCollections.observableArrayList(update);
    }

    private ObservableList<XYChart.Data<String, V>> update1(List<XYChart.Data<String, V>> data) {
        List<XYChart.Data<String, V>> update = new ArrayList<XYChart.Data<String, V>>();
        int pointCounter = data.size() / MAX_POINTS;
        for (int i = 0; i < data.size(); i++) {
            if(i%pointCounter == 0) {
                update.add(data.get(i));
            }
        }
        t1 = System.nanoTime();

        System.out.println(String.format("Reduces points from %d to %d in %.1f ms", data.size(), update.size(), (t1 - t0) / 1e6));
        return FXCollections.observableArrayList(update);
//        Reduces points from 10000 to 400 in 736086868.3 ms
//        Total time reduces points from 10000 to 400 in 736087199.1 ms
    }

    private ObservableList<XYChart.Data<String, V>> huge(List<XYChart.Data<String, V>> data) {
        List<XYChart.Data<String, V>> update = new ArrayList<XYChart.Data<String, V>>(data);

        System.out.println(String.format("Reduces points from %d to %d in %.1f ms", data.size(), update.size(), (t1 - t0) / 1e6));
//        Reduces points from 10000 to 10000 in 0.0 ms
//        Total time reduces points from 10000 to 10000 in 735918107.1 ms
        return FXCollections.observableArrayList(data);
    }

    private ObservableList<XYChart.Data<Number, Number>> update(Coordinate[] coordinates) {
        GeometryFactory gf = new GeometryFactory();
        Geometry geom = new LineString(new CoordinateArraySequence(coordinates), gf);
        Geometry simplified = DouglasPeuckerSimplifier.simplify(geom, 0.00001);
        List<XYChart.Data<Number, Number>> update = new ArrayList<XYChart.Data<Number, Number>>();
        for (Coordinate each : simplified.getCoordinates()) {
            update.add(new XYChart.Data<>(each.x, each.y));
        }
        t1 = System.nanoTime();

        System.out.println(String.format("Reduces points from %d to %d in %.1f ms", coordinates.length, update.size(), (t1 - t0) / 1e6));
        return FXCollections.observableArrayList(update);
    }

    private ObservableList<XYChart.Data<Number, Number>> huge(Coordinate[] coordinates) {
        List<XYChart.Data<Number, Number>> huge = new ArrayList<XYChart.Data<Number, Number>>();
        for (Coordinate each : coordinates) {
            huge.add(new XYChart.Data<>(each.x, each.y));
        }
        t1 = System.nanoTime();

        System.out.println(String.format("Reduces points from %d to %d in %.1f ms", coordinates.length, huge.size(), (t1 - t0) / 1e6));
        return FXCollections.observableArrayList(huge);
    }
}


