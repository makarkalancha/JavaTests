package com.everything.unit_measurement.pojo;

import com.everything.unit_measurement.Unit;

import java.math.BigDecimal;

/**
 * Created by mcalancea
 * Date: 09 Nov 2017
 * Time: 12:51
 */
public class Commodity {
    private String name;
    private BigDecimal price;
    private Unit unit;
    private BigDecimal unit_value;

    public Commodity(String name, BigDecimal price, Unit unit, BigDecimal unit_value) {
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.unit_value = unit_value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public BigDecimal getUnit_value() {
        return unit_value;
    }

    public void setUnit_value(BigDecimal unit_value) {
        this.unit_value = unit_value;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", unit=" + unit +
                ", unit_value=" + unit_value +
                '}';
    }
}
