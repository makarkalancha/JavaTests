package com.everything.javafx.pie_chart;

/**
 * Created by mcalancea
 * Date: 14 Nov 2017
 * Time: 11:29
 */
public class Fruit {
    private final String name;
    private final int quantity;

    public Fruit(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
