package com.everything.javafx.pie_chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mcalancea
 * Date: 13 Nov 2017
 * Time: 14:39
 */
public class PieChartDemo extends Application {
    private VBox vBox = new VBox();
    private StackPane stackPane = new StackPane();
    private PieChart chart = new PieChart();
    private Label caption = new Label("");
    private Button backBtn = new Button("back");

    private String title = "Imported Fruits";
    private ProgressIndicator progressIndicator = new ProgressIndicator(1);
    private Worker<Map<String, Fruit>> service = new GetSubFruitsService();

    public PieChartDemo() {
    }

    private Map<String, Fruit> pieChartFruits = new HashMap<>();
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> pieChartSubData = FXCollections.observableArrayList();

    private void initializeLists(){
        Fruit fruit = new Fruit("Grapefruit", 1);
        pieChartFruits.put(fruit.getName(), fruit);
        fruit = new Fruit("Oranges", 2);
        pieChartFruits.put(fruit.getName(), fruit);
        fruit = new Fruit("Plums", 3);
        pieChartFruits.put(fruit.getName(), fruit);
        fruit = new Fruit("Pears", 4);
        pieChartFruits.put(fruit.getName(), fruit);
        fruit = new Fruit("Apples", 5);
        pieChartFruits.put(fruit.getName(), fruit);
        fruit = new Fruit("Minus", -1);
//        pieChartFruits.put(fruit.getName(), fruit);
        fruit = new Fruit("None", 0);
        pieChartFruits.put(fruit.getName(), fruit);

        fillPieChartData(pieChartData, pieChartFruits);
    }

    private void fillPieChartData(ObservableList<PieChart.Data> destination, Map<String, Fruit> fruitMap){
        destination.clear();
        fruitMap.forEach((k, v) -> destination.add(new PieChart.Data(v.getName(), v.getQuantity())));
    }

    private void initializeServices(){
        ((Service<Map<String, Fruit>>)service).setOnSucceeded(event -> {
            progressIndicator.setProgress(1d);
            System.out.println("success");
            Map<String, Fruit> result = service.getValue();

            fillPieChartData(pieChartSubData, result);

            setChartData(((GetSubFruitsService) service).getSelected(), pieChartSubData, false);

            backBtn.setVisible(true);
        });
        ((Service<Map<String, Fruit>>)service).setOnFailed(event -> {
            progressIndicator.setProgress(1d);
            System.out.println("fail");
        });
    }

    private void pieChartSetMouseEvent(ObservableList<PieChart.Data> dataList, boolean isServiceSet){
        double totalPie = dataList.stream()
                .mapToDouble(d -> d.getPieValue())
                .sum();

        for (PieChart.Data data :  chart.getData()) {
            StringBuilder text = new StringBuilder();
            text.append("name: ");
            text.append(data.getName());
            text.append("\n");
            text.append("value: ");
            text.append(data.getPieValue());
            text.append("\n");
            text.append("percentage: ");
            text.append(Math.round(data.getPieValue() / totalPie * 100 * 100) / 100);
            text.append("%");

            data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, new PieChartMouseEventExited(caption));
            data.getNode().addEventHandler(MouseEvent.MOUSE_MOVED, new PieChartMouseEventMoved(stackPane, caption, text.toString()));
            if (isServiceSet){
                data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new PieChartMouseEventClicked((GetSubFruitsService) service, progressIndicator, data.getName()));
            }
        }
    }

    private void setChartData(String title, ObservableList<PieChart.Data> pieChartData, boolean isServiceSet){
        chart.setTitle(title);
        chart.setData(pieChartData);
        pieChartSetMouseEvent(pieChartData, isServiceSet);
    }

    @Override
    public void start(Stage stage) {
        initializeLists();
        initializeServices();

        stage.setTitle(title);
        stage.setWidth(500);
        stage.setHeight(500);

        Scene scene = new Scene(new Group());


        chart.setAnimated(true);

//        caption.setTextFill(Color.DARKORANGE);
        caption.getStyleClass().addAll("default-color0", "chart-line-symbol", "chart-series-line");
        caption.setStyle("--fx-font-size: 20; -fx-font-weight: bold;");
        caption.setTextFill(Color.BLACK);
        caption.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);
        caption.setVisible(false);

        setChartData(title, pieChartData, true);

        backBtn.setVisible(false);
        backBtn.setOnAction(event -> {
            pieChartSubData.clear();
            setChartData(title, pieChartData, true);
            backBtn.setVisible(false);
        });

        stackPane.getChildren().addAll(chart, caption, backBtn);
        StackPane.setMargin(backBtn, new Insets(5, 0, 0, 5));
        StackPane.setAlignment(backBtn, Pos.TOP_LEFT);

        Label test = new Label("test");
        vBox.getChildren().addAll(stackPane, test, progressIndicator);
        ((Group) scene.getRoot()).getChildren().add(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
