package com.everything.design_patterns.headfirst.strategy.behavior.quack;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 11:40 AM
 */
public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
