package com.test.everything.design_patterns.headfirst.decorator.components.beverages;

import com.test.everything.design_patterns.headfirst.decorator.components.Beverage;

/**
 * User: Makar Kalancha
 * Date: 31/07/14
 * Time: 3:13 PM
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        _description = "House Blend";
    }

    @Override
    public double cost() {
        return .89;
    }
}
