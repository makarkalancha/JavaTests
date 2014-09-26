package com.test.everything.design_patterns.headfirst.decorator;


import com.test.everything.design_patterns.headfirst.decorator.components.Beverage;
import com.test.everything.design_patterns.headfirst.decorator.components.beverages.Espresso;
import com.test.everything.design_patterns.headfirst.decorator.components.beverages.HouseBlend;
import com.test.everything.design_patterns.headfirst.decorator.components.condiments.Mocha;
import com.test.everything.design_patterns.headfirst.decorator.components.condiments.Soy;
import com.test.everything.design_patterns.headfirst.decorator.components.condiments.Whip;

/**
 * User: Makar Kalancha
 * Date: 31/07/14
 * Time: 3:17 PM
 */
public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()+": "+beverage.cost());

        Beverage beverage1 = new HouseBlend();
        beverage1 = new Soy(beverage1);
        beverage1 = new Whip(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println(beverage1.getDescription()+": "+beverage1.cost());

    }
}
