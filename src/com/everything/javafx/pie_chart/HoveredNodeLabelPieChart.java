package com.everything.javafx.pie_chart;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Created by mcalancea
 * Date: 14 Nov 2017
 * Time: 08:52
 */
public class HoveredNodeLabelPieChart extends VBox {
    private static final int PADDING = 5;

    private final StackPane stackPane;
    private final Label label;
    private final String labelText;

    public HoveredNodeLabelPieChart(StackPane stackP, Label labelObj, String value) {
        this.stackPane = stackP;
        this.label = labelObj;
        this.labelText = value;
//        setPrefSize(15, 15);
//        setStyle(UserInterfaceConstants.TRANSPARENT_BGCOLOR);
        setPrefSize(5, 5);

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setCursor(Cursor.NONE);
                toFront();
                label.setVisible(true);
                changeLabel();
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                getChildren().clear();
                setCursor(Cursor.CROSSHAIR);
                label.setVisible(false);
            }
        });
    }

    private void changeLabel() {
        label.setText(labelText + ""); //if labelText is null
        label.getStyleClass().addAll("default-color0", "chart-line-symbol", "chart-series-line");
        label.setStyle("--fx-font-size: 20; -fx-font-weight: bold;");

        label.setTextFill(Color.FIREBRICK);

        label.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);

        StackPane.setAlignment(label, Pos.TOP_LEFT);
        stackPane.setOnMouseMoved(mouseEvent1 ->{
            double halfH = stackPane.getHeight() / 2;
            double halfW = stackPane.getWidth() / 2;
            double mouseX = mouseEvent1.getX();
            double mouseY = mouseEvent1.getY();
            double deltaX = (mouseX < halfW) ? PADDING : -1 * label.getWidth() - PADDING;
            double deltaY = (mouseY < halfH) ? PADDING : -1 * label.getHeight() - PADDING;

            StackPane.setMargin(label, new Insets(
                    mouseY + deltaY,
                    0,
                    0,
                    mouseX + deltaX));
        });

        stackPane.setOnMouseExited(mouseEvent1 -> {
            label.setVisible(false);
        });
    }
}
