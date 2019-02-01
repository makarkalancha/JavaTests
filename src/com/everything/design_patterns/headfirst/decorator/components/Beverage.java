package com.everything.design_patterns.headfirst.decorator.components;

/**
 * User: Makar Kalancha
 * Date: 31/07/14
 * Time: 3:10 PM
 */
public abstract class  Beverage {
    protected String _description = "Unknown Beverage";

    public String getDescription() {
        return _description;
    }

    public abstract double cost();

}
