package everything.javafx.linechart;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by Makar Kalancha
 * Date: 18 May 2017
 * Time: 10:36
 */
public class LineChartInStackPane extends Application {
    private final CategoryAxis xAxis = new CategoryAxis();
    private final NumberAxis yAxis = new NumberAxis();
    private final LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

    private Label coordLabel;
    private Label coordLabelLineChart;
    private final Label label = new Label("text");
    private final Label label1 = new Label("text1");

    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart Sample");
        //defining the axes
        xAxis.setLabel("Number of Month");

        coordLabel = createCursorGraphCoordsMonitorLabel(lineChart);
        coordLabelLineChart = createCursorGraphCoordsMonitorLabelLineChart(lineChart);

        //creating the chart
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

        lineChart.getData().addAll(series2, series1);

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


        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(lineChart);
        stackPane.getChildren().add(label1);
        stackPane.getChildren().add(label);

        HBox hBox1 = new HBox(new Label("linechart: "), coordLabelLineChart);
        HBox hBox2 = new HBox(new Label("plot: "), coordLabel);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox1, hBox2, stackPane);

//        lineChart.getTitleSide()


        Scene scene = new Scene(vBox, 800, 600);
        stage.setScene(scene);
        stage.show();

        final Node chartBackground = lineChart.lookup(".chart-plot-background");
        for (Node n : chartBackground.getParent().getChildrenUnmodifiable()) {
            if (n != chartBackground && n != xAxis && n != yAxis) {
                n.setMouseTransparent(true);
            }
        }

        final Node chartTitle = lineChart.lookup(".chart-title");
        final Node chartContent = lineChart.lookup(".chart-content");

        label.setStyle("-fx-background-color: blue ");
        label1.setStyle("-fx-background-color: deepskyblue ");
        lineChart.setStyle("-fx-background-color: red ");
        chartBackground.setStyle("-fx-background-color: lightgreen ");
        chartTitle.setStyle("-fx-background-color: ivory  ");
        chartContent.setStyle("-fx-background-color: powderblue   ");

        Bounds boundsChartBackground = chartBackground.getLayoutBounds();
        double hChartBackground = boundsChartBackground.getHeight();
        double wChartBackground = boundsChartBackground.getWidth();
        System.out.println("chartBackground->");
        System.out.println("wChartBackground:" + wChartBackground + "; hChartBackground:" + hChartBackground);
        double xChartBackground = chartBackground.getLayoutX();
        double yChartBackground = chartBackground.getLayoutY();
        System.out.println("xChartBackground:" + xChartBackground + "; yChartBackground:" + yChartBackground);

        Bounds boundsChartTitle = chartTitle.getLayoutBounds();
        double hChartTitle = boundsChartTitle.getHeight();
        double wChartTitle = boundsChartTitle.getWidth();
        System.out.println("ChartTitle->");
        System.out.println("wChartTitle:" + wChartTitle + "; hChartTitle:" + hChartTitle);
        double xChartTitle = chartTitle.getLayoutX();
        double yChartTitle = chartTitle.getLayoutY();
        System.out.println("xChartTitle:" + xChartTitle + "; yChartTitle:" + yChartTitle);

        Bounds boundsChartContent = chartContent.getLayoutBounds();
        double hChartContent = boundsChartContent.getHeight();
        double wChartContent = boundsChartContent.getWidth();
        System.out.println("ChartContent->");
        System.out.println("wChartContent:" + wChartContent + "; hChartContent:" + hChartContent);
        double xChartContent = chartContent.getLayoutX();
        double yChartContent = chartContent.getLayoutY();
        System.out.println("xChartContent:" + xChartContent + "; yChartContent:" + yChartContent);

        Bounds boundsLineChart = lineChart.getLayoutBounds();
        double hLineChart = boundsLineChart.getHeight();
        double wLineChart = boundsLineChart.getWidth();
        System.out.println("lineChart->");
        System.out.println("wLineChart:" + wLineChart + "; hLineChart:" + hLineChart);
        double xLineChart = lineChart.getLayoutX();
        double yLineChart = lineChart.getLayoutY();
        System.out.println("xLineChart:" + xLineChart + "; yLineChart:" + yLineChart);

        StackPane.setAlignment(label, Pos.TOP_RIGHT);
        StackPane.setAlignment(label1, Pos.TOP_LEFT);
//        StackPane.setMargin(label, new Insets(hLineChart - hChartBackground, 0, 0, 0));
//        StackPane.setMargin(label, new Insets(xChartBackground + 6, yChartBackground + 4, 0, 0));
        StackPane.setMargin(label, new Insets(
//                xChartBackground + 6,
                yChartTitle+hChartTitle+yChartBackground,
                wChartContent - wChartBackground - xChartBackground + xChartContent,
                0,
                0));
        StackPane.setMargin(label1, new Insets(xChartBackground, 0, 0, yChartBackground));
//        Insets insets = stackPane.getPadding();
//        System.out.println(insets);





//        Set<String> strings = new TreeSet<>();
//        strings.add("1");
//        strings.add("2");
//        strings.add("3");
//        strings.add("10");
//        strings.add("11");
//        strings.add("12");
//        strings.add("13");
//        strings.add("14");
//        strings.add("15");
//        strings.add("4");
//        strings.add("5");
//        strings.add("6");
//        strings.add("7");
//        strings.add("8");
//        strings.add("9");
//        strings.add("16");
//        strings.add("17");
//        strings.add("18");
//        strings.add("19");
//        strings.add("20");
//        System.out.println(strings);
    }

    private Label createCursorGraphCoordsMonitorLabel(LineChart<String, Number> lineChart) {
        final Axis<String> xAxis = lineChart.getXAxis();
        final Axis<Number> yAxis = lineChart.getYAxis();

        final Label cursorCoords = new Label();

        final Node chartBackground = lineChart.lookup(".chart-plot-background");
        for (Node n : chartBackground.getParent().getChildrenUnmodifiable()) {
            if (n != chartBackground && n != xAxis && n != yAxis) {
                n.setMouseTransparent(true);
            }
        }

        chartBackground.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(true);
            }
        });

        chartBackground.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setText(
                        String.format(
//                                "(%s, %.2f)",
//                                xAxis.getValueForDisplay(mouseEvent.getX()),
//                                yAxis.getValueForDisplay(mouseEvent.getY())
                                "(%.2f, %.2f)",
                                mouseEvent.getX(),
                                mouseEvent.getY()
                        )
                );
            }
        });

        chartBackground.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(false);
            }
        });

        xAxis.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(true);
            }
        });

        xAxis.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setText(
                        String.format(
                                "x = %s",
                                xAxis.getValueForDisplay(mouseEvent.getX())
                        )
                );
            }
        });

        xAxis.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(false);
            }
        });

        yAxis.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(true);
            }
        });

        yAxis.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setText(
                        String.format(
                                "y = %.2f",
                                yAxis.getValueForDisplay(mouseEvent.getY())
                        )
                );
            }
        });

        yAxis.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(false);
            }
        });

        return cursorCoords;
    }

    private Label createCursorGraphCoordsMonitorLabelLineChart(LineChart<String, Number> lineChart) {
        final Axis<String> xAxis = lineChart.getXAxis();
        final Axis<Number> yAxis = lineChart.getYAxis();

        final Label cursorCoords = new Label();

        lineChart.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(true);
            }
        });

        lineChart.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setText(
                        String.format(
                                "(%.2f, %.2f)",
                                mouseEvent.getX(),
                                mouseEvent.getY()
                        )
                );
            }
        });

        lineChart.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                cursorCoords.setVisible(false);
            }
        });

        return cursorCoords;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
