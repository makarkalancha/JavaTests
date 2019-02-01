package com.everything.design_patterns.headfirst.strategy.duck;

import com.everything.design_patterns.headfirst.strategy.behavior.fly.FlyNoWay;
import com.everything.design_patterns.headfirst.strategy.behavior.quack.Quack;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 11:46 AM
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
