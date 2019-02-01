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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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
    private ComboBox<String> comboBox = new ComboBox<>();

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

//        fruit = new Fruit("7", 7);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("8", 8);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("9", 9);
//        pieChartFruits.put(fruit.getName(), fruit);
//        ////////////////10/////////////////////////////////
//        fruit = new Fruit("10", 10);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("11", 11);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("12", 12);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("13", 13);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("14", 14);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("15", 15);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("16", 16);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("17", 17);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("18", 18);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("19", 19);
//        pieChartFruits.put(fruit.getName(), fruit);
//        ////////////////20/////////////////////////////////
//        fruit = new Fruit("20", 20);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("21", 21);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("22", 22);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("23", 23);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("24", 24);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("25", 25);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("26", 26);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("27", 27);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("28", 28);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("29", 29);
//        pieChartFruits.put(fruit.getName(), fruit);
//        ////////////////30/////////////////////////////////
//        fruit = new Fruit("30", 30);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("31", 31);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("32", 32);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("33", 33);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("34", 34);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("35", 35);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("36", 36);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("37", 37);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("38", 38);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("39", 39);
//        pieChartFruits.put(fruit.getName(), fruit);
//        ////////////////40/////////////////////////////////
//        fruit = new Fruit("40", 40);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("41", 41);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("42", 42);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("43", 43);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("44", 44);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("45", 45);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("46", 46);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("47", 47);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("48", 48);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("49", 49);
//        pieChartFruits.put(fruit.getName(), fruit);
//        ////////////////50/////////////////////////////////
//        fruit = new Fruit("50", 50);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("51", 51);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("52", 52);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("53", 53);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("54", 54);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("55", 55);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("56", 56);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("57", 57);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("58", 58);
//        pieChartFruits.put(fruit.getName(), fruit);
//        fruit = new Fruit("59", 59);
//        pieChartFruits.put(fruit.getName(), fruit);

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
                data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new PieChartMouseEventClicked((GetSubFruitsService) service, progressIndicator, comboBox, data.getName()));
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
//        chart.setLegendSide(Side.LEFT);

//        caption.setTextFill(Color.DARKORANGE);
        caption.getStyleClass().addAll("default-color0", "chart-line-symbol", "chart-series-line");
        caption.setStyle("--fx-font-size: 20; -fx-font-weight: bold;");
        caption.setTextFill(Color.BLACK);
        caption.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);
        caption.setVisible(false);

        setChartData(title, pieChartData, true);
        comboBox.setItems(
                FXCollections.observableArrayList(
                        pieChartData.stream()
                                .map(data -> data.getName())
                                .collect(Collectors.toList())
                )
        );
        comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && StringUtils.isNotBlank(newValue) && !newValue.equals(oldValue)) {
                progressIndicator.setProgress(-1d);
                if (service != null) {
                    ((GetSubFruitsService)service).setSelected(newValue);
                    ((GetSubFruitsService)service).restart();
                }
            }
        });

        backBtn.setVisible(false);
        backBtn.setOnAction(event -> {
            pieChartSubData.clear();
            setChartData(title, pieChartData, true);
            backBtn.setVisible(false);
            comboBox.setValue(null);
        });

        stackPane.setStyle("-fx-background-color: #90ee90");
        stackPane.getChildren().addAll(chart, caption, backBtn, comboBox);
        StackPane.setMargin(backBtn, new Insets(5, 0, 0, 5));
        StackPane.setAlignment(backBtn, Pos.TOP_LEFT);

        StackPane.setMargin(comboBox, new Insets(5, 25, 0, 0));
        StackPane.setAlignment(comboBox, Pos.TOP_RIGHT);

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
