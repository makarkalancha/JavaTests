package com.everything.design_patterns.headfirst.strategy;

import com.everything.design_patterns.headfirst.strategy.behavior.fly.FlyRocketPowered;
import com.everything.design_patterns.headfirst.strategy.duck.Duck;
import com.everything.design_patterns.headfirst.strategy.duck.MallardDuck;
import com.everything.design_patterns.headfirst.strategy.duck.ModelDuck;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 11:41 AM
 */
public class DuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();

        System.out.println();

        Duck model = new ModelDuck();
        model.display();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
