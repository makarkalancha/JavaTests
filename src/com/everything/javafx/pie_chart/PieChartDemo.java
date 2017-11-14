package com.everything.javafx.pie_chart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Worker;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
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
    private ProgressIndicator progressIndicator = new ProgressIndicator(1);
    private Worker<Void> service = new GetSubFruitsService();
    private String selectedFruit;

    public PieChartDemo() {
    }

    private Map<String, Fruit> pieChartFruits = new HashMap<>();
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

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

        pieChartFruits.forEach((k, v) -> pieChartData.add(new PieChart.Data(v.getName(), v.getQuantity())));
    }

    private void initializeServices(){
        ((Service<Void>)service).setOnSucceeded(event -> {
            progressIndicator.setProgress(1d);
            System.out.println("success");
        });
        ((Service<Void>)service).setOnFailed(event -> {
            progressIndicator.setProgress(1d);
            System.out.println("fail");
        });
    }

    private ObservableList<PieChart.Data> pieChartGrapefruitData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Grapefruit1", 10),
                    new PieChart.Data("Grapefruit2", 20),
                    new PieChart.Data("Grapefruit3", 30));
    private ObservableList<PieChart.Data> pieChartOrangesData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Oranges1", 40),
                    new PieChart.Data("Oranges2", 30),
                    new PieChart.Data("Oranges3", 20),
                    new PieChart.Data("Oranges4", 10));
    private ObservableList<PieChart.Data> pieChartPlumsData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Plums1", 10),
                    new PieChart.Data("Plums2", 20),
                    new PieChart.Data("Plums3", 30),
                    new PieChart.Data("Plums4", 40),
                    new PieChart.Data("Plums5", 50));
    private ObservableList<PieChart.Data> pieChartPearsData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Pears1", 60),
                    new PieChart.Data("Pears2", 50),
                    new PieChart.Data("Pears3", 40),
                    new PieChart.Data("Pears4", 30),
                    new PieChart.Data("Pears5", 20),
                    new PieChart.Data("Pears6", 10));
    private ObservableList<PieChart.Data> pieChartApplesData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Apples1", 10),
                    new PieChart.Data("Apples2", 20),
                    new PieChart.Data("Apples3", 30),
                    new PieChart.Data("Apples4", 40),
                    new PieChart.Data("Apples5", 50),
                    new PieChart.Data("Apples6", 60),
                    new PieChart.Data("Apples7", 70));
    
    @Override
    public void start(Stage stage) {
        initializeLists();
        initializeServices();

        stage.setTitle("Imported Fruits");
        stage.setWidth(500);
        stage.setHeight(500);

        Scene scene = new Scene(new Group());

        double totalPie = pieChartData.stream()
                .mapToDouble(d -> d.getPieValue())
                .sum();

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");

        final Label caption = new Label("");
//        caption.setTextFill(Color.DARKORANGE);
        caption.getStyleClass().addAll("default-color0", "chart-line-symbol", "chart-series-line");
        caption.setStyle("--fx-font-size: 20; -fx-font-weight: bold;");
        caption.setTextFill(Color.BLACK);
        caption.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);
        caption.setVisible(false);

        for (PieChart.Data data :  chart.getData()) {
            StringBuilder text = new StringBuilder();
            text.append("value: ");
            text.append(data.getPieValue());
            text.append("\n");
            text.append("percentage: ");
            text.append(Math.round(data.getPieValue() / totalPie * 100 * 100) / 100);
            text.append("%");
            data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, new PieChartMouseEventExited(caption));
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new PieChartMouseEventEntered(stackPane, caption, text.toString()));
            selectedFruit = data.getName();
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new PieChartMouseEventClicked((GetSubFruitsService) service, progressIndicator, data.getName()));

//                    new EventHandler<MouseEvent>() {
//                        @Override
//                        public void handle(MouseEvent e) {
////                            data.setNode(new HoveredNodeLabelPieChart(stackPane, caption, data.getPieValue())
////                            caption.setTranslateX(e.getX());
////                            caption.setTranslateY(e.getY());
//                            caption.setVisible(true);
//                            caption.setText(String.valueOf(data.getPieValue()) + "%");
//                            stackPane.setOnMouseMoved(mouseEvent1 ->{
//                                double halfH = stackPane.getHeight() / 2;
//                                double halfW = stackPane.getWidth() / 2;
//                                double mouseX = e.getX();
//                                double mouseY = e.getY();
//                                double deltaX = (mouseX < halfW) ? 5 : -1 * caption.getWidth() - 5;
//                                double deltaY = (mouseY < halfH) ? 5 : -1 * caption.getHeight() - 5;
//
//                                StackPane.setMargin(caption, new Insets(
//                                        mouseY + deltaY,
//                                        0,
//                                        0,
//                                        mouseX + deltaX));
//                            });
//
//                            stackPane.setOnMouseExited(mouseEvent1 -> {
//                                caption.setVisible(false);
//                            });
//
////                            System.out.println("x: " + e.getScreenX());
////                            System.out.println("y: " + e.getScreenY());
////                            System.out.println("data.name: " + data.getName());
////                            System.out.println("data.value: " + data.getPieValue());
////                            System.out.println("data.node: " + data.getNode().lookupAll(String.format(".default-color%d.chart-pie", index)));
////                            String style = data.getNode().getStyleClass().stream().filter(s -> s.startsWith("default-color")).findFirst().orElse(null);
////                            System.out.println(style);
////                            CssMetaData value = data.getNode().getCssMetaData().stream()
////                                    .filter(p -> p.getProperty().equals(style))
////                                    .findFirst()
////                                    .orElse(null);
////                            System.out.println(value);
//////                            data.getNode().getCssMetaData().forEach(System.out::println);
//////                            https://stackoverflow.com/questions/25186238/constant-colors-on-a-piechart
//////
//////                            reverse color
//////                            https://stackoverflow.com/questions/4672271/reverse-opposing-colors
//                        }
//                    });
        }

        stackPane.getChildren().addAll(chart, caption);
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
