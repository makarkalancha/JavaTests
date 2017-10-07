package com.everything.design_patterns.headfirst.strategy.behavior.fly;

/**
 * User: Makar Kalancha
 * Date: 17/07/14
 * Time: 4:32 PM
 */
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("Fly No Way.");
    }
}
