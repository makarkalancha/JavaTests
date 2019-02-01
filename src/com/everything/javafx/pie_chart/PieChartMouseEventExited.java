package com.everything.javafx.pie_chart;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * Created by mcalancea
 * Date: 14 Nov 2017
 * Time: 09:09
 */
public class PieChartMouseEventExited implements EventHandler<MouseEvent> {
    private final Label label;

    public PieChartMouseEventExited(Label label) {
        this.label = label;
    }

    @Override
    public void handle(MouseEvent event) {
        label.setVisible(false);
    }
}
