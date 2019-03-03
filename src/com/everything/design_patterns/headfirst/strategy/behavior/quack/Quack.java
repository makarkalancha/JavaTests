package com.everything.design_patterns.headfirst.strategy.behavior.quack;

/**
 * User: Makar Kalancha
 * Date: 17/07/14
 * Time: 4:33 PM
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack!");
    }
}
