package com.everything.design_patterns.headfirst.decorator.components.condiments;

import com.everything.design_patterns.headfirst.decorator.components.Beverage;
import com.everything.design_patterns.headfirst.decorator.components.CondimentDecorator;

/**
 * User: Makar Kalancha
 * Date: 31/07/14
 * Time: 3:15 PM
 */
public class Soy extends CondimentDecorator {
    Beverage _beverage;
    public Soy(Beverage beverage) {
        this._beverage = beverage;
    }

    @Override
    public String getDescription() {
        return _beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return .10+_beverage.cost();
    }
}
