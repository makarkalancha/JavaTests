package com.everything.javafx.pie_chart;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

/**
 * Created by mcalancea
 * Date: 14 Nov 2017
 * Time: 09:09
 */
public class PieChartMouseEventMoved implements EventHandler<MouseEvent> {
    private final StackPane stackPane;
    private final Label label;
    private final String data;

    public PieChartMouseEventMoved(StackPane stackPane, Label label, String data) {
        this.stackPane = stackPane;
        this.label = label;
        this.data = data;
    }

    @Override
    public void handle(MouseEvent event) {
        label.setVisible(true);
        label.setText(data);
//        label.setTranslateX(event.getX());
//        label.setTranslateY(event.getY());
        stackPane.setOnMouseMoved(mouseEvent1 ->{
            double halfH = stackPane.getHeight() / 2;
            double halfW = stackPane.getWidth() / 2;
            double mouseX = event.getX();
            double mouseY = event.getY();
            double deltaX = (mouseX < halfW) ? 30 : -1 * label.getWidth() - 30;
            double deltaY = (mouseY < halfH) ? 30 : -1 * label.getHeight() - 30;
//            System.out.println("y:" + (mouseY + deltaY));
//            System.out.println("x:" + (mouseX + deltaX));
            label.setTranslateX(mouseX + deltaY);
            label.setTranslateY(mouseY + deltaX);
//            StackPane.setMargin(label, new Insets(
//                    mouseY + deltaY,
//                    0,
//                    0,
//                    mouseX + deltaX));
        });

        stackPane.setOnMouseExited(mouseEvent1 -> {
            label.setVisible(false);
        });
    }
}
