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
    private BigDecimal unitValue;

    public Commodity(String name, BigDecimal price, Unit unit, BigDecimal unitValue) {
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.unitValue = unitValue;
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

    public BigDecimal getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(BigDecimal unitValue) {
        this.unitValue = unitValue;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", unit=" + unit +
                ", unitValue=" + unitValue +
                '}';
    }
}
