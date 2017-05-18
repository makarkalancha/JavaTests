package everything.javafx.linechart;

import javafx.application.Application;
import javafx.collections.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * User: Makar Kalancha
 * Date: 17/05/2017
 * Time: 23:24
 */
public class LineChartWithHover extends Application {
    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private Node chartBackground;
    private Label coord = new Label();

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage stage) {
        final LineChart lineChart = new LineChart(xAxis, yAxis);
//        chartBackground = lineChart.lookup(".chart-plot-background");
//        for (Node n : chartBackground.getParent().getChildrenUnmodifiable()) {
//            if (n != chartBackground && n != xAxis && n != yAxis) {
//                n.setMouseTransparent(true);
//            }
//        }

        lineChart.setData(
                FXCollections.observableArrayList(
                        new XYChart.Series(
                                "My portfolio",
                                FXCollections.observableArrayList(
                                        plot(23, 0, 50, 14, 15, 24, 34, 36, 22, 45, 43, 17, 29, 25,
                                                23, 1, 50, 14, 15, 24, 34, 36, 22, 45, 43, 17, 29, 25,
                                                23, 1, 50, 14, 15, 24, 34, 36, 22, 45, 43, 17, 29, 25,
                                                23, 1, 50, 14, 15, 24, 34, 36, 22, 45, 43, 17, 29, 25,
                                                23, 1, 50, 14, 15, 24, 34, 36, 22, 45, 43, 17, 29, 25)
                                )
                        )
                )
        );
        lineChart.setCursor(Cursor.CROSSHAIR);
        lineChart.setTitle("Stock Monitoring, 2013");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(coord, lineChart);
        stage.setScene(new Scene(vBox, 500, 400));
//        stage.setScene(new Scene(lineChart, 500, 400));
        stage.show();
    }

    /** @return plotted y values for monotonically increasing integer x values, starting from x=1 */
    public ObservableList<XYChart.Data<Integer, Integer>> plot(int... y) {
        final ObservableList<XYChart.Data<Integer, Integer>> dataset = FXCollections.observableArrayList();
        int i = 0;
        while (i < y.length) {
            final XYChart.Data<Integer, Integer> data = new XYChart.Data<>(i + 1, y[i]);
            data.setNode(
                    new HoveredThresholdNode(
                            xAxis,
                            yAxis,
                            coord,
                            chartBackground,
                            (i == 0) ? 0 : y[i-1],
                            y[i]
                    )
            );

            dataset.add(data);
            i++;
        }

        return dataset;
    }

    /** a node which displays a value on hover, but is otherwise empty */
    private static class HoveredThresholdNode extends StackPane {
        HoveredThresholdNode(NumberAxis xAxis, NumberAxis yAxis, Label coord, Node chartBackground, int priorValue, int value) {
            setPrefSize(15, 15);
            setStyle("-fx-background-color: rgba(0,0,0,0);");




            final Label label = createDataThresholdLabel(priorValue, value);

            setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    getChildren().setAll(label);
                    setCursor(Cursor.NONE);
                    toFront();
                    double top = 0d;
                    double right = 0d;
                    double bottom = 0d;
                    double left = 0d;
                    if()
                    setMargin(label, new Insets(top, right, bottom, left));
                    System.out.println("=============================================================");
                    System.out.println("x:" + event.getX() + "; y:" + event.getY());
//                    System.out.println("getScreenX:"+event.getScreenX()+"; getScreenY:"+event.getScreenY());
                    System.out.println("getSceneX:" + event.getSceneX() + "; getSceneY:" + event.getSceneY());
                    System.out.println("xAxis:" + xAxis.getValueForDisplay(event.getX()) + "; yAxis:" + yAxis.getValueForDisplay(event.getY()));
                    System.out.println("xAxis.getWidth():" + xAxis.getWidth()+"; yAxis.getHeight():" + yAxis.getHeight());
                }
            });
            setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    getChildren().clear();
                    setCursor(Cursor.CROSSHAIR);
                }
            });

//            chartBackground.setOnMouseEntered(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent mouseEvent) {
//                    coord.setVisible(true);
//                }
//            });

//            chartBackground.setOnMouseMoved(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent mouseEvent) {
//                    coord.setText(
//                            String.format(
//                                    "(%.2f, %.2f)",
//                                    xAxis.getValueForDisplay(mouseEvent.getX()),
//                                    yAxis.getValueForDisplay(mouseEvent.getY())
//                            )
//                    );
//                }
//            });

//            chartBackground.setOnMouseExited(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent mouseEvent) {
//                    coord.setVisible(false);
//                }
//            });


        }

        private Label createDataThresholdLabel(int priorValue, int value) {
            final Label label = new Label(value + "");
            label.getStyleClass().addAll("default-color0", "chart-line-symbol", "chart-series-line");
            label.setStyle("-fx-font-size: 20; -fx-font-weight: bold;");

            if (priorValue == 0) {
                label.setTextFill(Color.DARKGRAY);
            } else if (value > priorValue) {
                label.setTextFill(Color.FORESTGREEN);
            } else {
                label.setTextFill(Color.FIREBRICK);
            }

            label.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);
            return label;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
