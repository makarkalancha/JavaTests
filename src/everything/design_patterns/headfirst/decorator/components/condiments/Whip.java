package com.test.everything.design_patterns.headfirst.decorator.components.condiments;

import com.test.everything.design_patterns.headfirst.decorator.components.Beverage;
import com.test.everything.design_patterns.headfirst.decorator.components.CondimentDecorator;

/**
 * User: Makar Kalancha
 * Date: 31/07/14
 * Time: 3:15 PM
 */
public class Whip extends CondimentDecorator {
    Beverage _beverage;
    public Whip(Beverage beverage) {
        this._beverage = beverage;
    }

    @Override
    public String getDescription() {
        return _beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .15+_beverage.cost();
    }
}
