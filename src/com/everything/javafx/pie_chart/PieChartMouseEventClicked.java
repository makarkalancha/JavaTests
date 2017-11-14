package com.everything.javafx.pie_chart;

import javafx.event.EventHandler;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;

/**
 * Created by mcalancea
 * Date: 14 Nov 2017
 * Time: 09:09
 */
public class PieChartMouseEventClicked implements EventHandler<MouseEvent> {
    private final GetSubFruitsService service;
    private final ProgressIndicator progressIndicator;
    private final String selected;

    public PieChartMouseEventClicked(GetSubFruitsService service, ProgressIndicator progressIndicator, String selected) {
        this.service = service;
        this.progressIndicator = progressIndicator;
        this.selected = selected;
    }

    @Override
    public void handle(MouseEvent event) {
        progressIndicator.setProgress(-1d);
        if (service != null) {
            service.setSelected(selected);
            service.restart();
        }
    }
}
