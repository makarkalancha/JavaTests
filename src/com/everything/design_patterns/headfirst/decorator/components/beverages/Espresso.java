package com.everything.design_patterns.headfirst.decorator.components.beverages;

import com.everything.design_patterns.headfirst.decorator.components.Beverage;

/**
 * User: Makar Kalancha
 * Date: 31/07/14
 * Time: 3:13 PM
 */
public class Espresso extends Beverage {
    public Espresso() {
        _description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
