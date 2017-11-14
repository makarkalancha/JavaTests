package com.everything.javafx.pie_chart;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by mcalancea
 * Date: 14 Nov 2017
 * Time: 12:33
 */
public class GetSubFruitsService extends Service<Void> {
    private String selected;

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    @Override
    protected Task<Void> createTask() {
        return new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                if(StringUtils.isNotBlank(selected)) {
                    System.out.println(selected);
                    try {
                        Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };
    }
}
