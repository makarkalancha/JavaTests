package com.everything.javafx.pie_chart;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by mcalancea
 * Date: 14 Nov 2017
 * Time: 12:33
 */
public class GetSubFruitsService extends Service<Map<String, Fruit>> {
    private String selected;

    private static Multimap<String, Fruit> fruitMultimap = HashMultimap.create();
    static {
        fruitMultimap.put("Grapefruit", new Fruit("Grapefruit1", 10));
        fruitMultimap.put("Grapefruit", new Fruit("Grapefruit2", 20));
        fruitMultimap.put("Grapefruit", new Fruit("Grapefruit3", 30));

        fruitMultimap.put("Oranges", new Fruit("Oranges1", 40));
        fruitMultimap.put("Oranges", new Fruit("Oranges2", 30));
        fruitMultimap.put("Oranges", new Fruit("Oranges3", 20));
        fruitMultimap.put("Oranges", new Fruit("Oranges4", 10));

        fruitMultimap.put("Plums", new Fruit("Plums1", 10));
        fruitMultimap.put("Plums", new Fruit("Plums2", 20));
        fruitMultimap.put("Plums", new Fruit("Plums3", 30));
        fruitMultimap.put("Plums", new Fruit("Plums4", 40));
        fruitMultimap.put("Plums", new Fruit("Plums5", 50));

        fruitMultimap.put("Pears", new Fruit("Pears1", 60));
        fruitMultimap.put("Pears", new Fruit("Pears2", 50));
        fruitMultimap.put("Pears", new Fruit("Pears3", 40));
        fruitMultimap.put("Pears", new Fruit("Pears4", 30));
        fruitMultimap.put("Pears", new Fruit("Pears5", 20));
        fruitMultimap.put("Pears", new Fruit("Pears6", 10));

        fruitMultimap.put("Apples", new Fruit("Apples1", 10));
        fruitMultimap.put("Apples", new Fruit("Apples2", 20));
        fruitMultimap.put("Apples", new Fruit("Apples3", 30));
        fruitMultimap.put("Apples", new Fruit("Apples4", 40));
        fruitMultimap.put("Apples", new Fruit("Apples5", 50));
        fruitMultimap.put("Apples", new Fruit("Apples6", 60));
        fruitMultimap.put("Apples", new Fruit("Apples7", 70));
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    @Override
    protected Task<Map<String, Fruit>> createTask() {
        return new Task<Map<String, Fruit>>() {
            @Override
            protected Map<String, Fruit> call() throws Exception {
                Map<String, Fruit> result = new HashMap<>();
                if(StringUtils.isNotBlank(selected)) {
                    System.out.println(selected);
                    try {
                        Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fruitMultimap.get(selected).forEach(fruit -> result.put(fruit.getName(), fruit));
                }
                return result;
            }
        };
    }
}
