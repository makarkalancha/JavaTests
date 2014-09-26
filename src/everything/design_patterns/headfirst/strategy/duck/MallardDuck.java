package everything.design_patterns.headfirst.strategy.duck;

import everything.design_patterns.headfirst.strategy.behavior.fly.FlyWithWings;
import everything.design_patterns.headfirst.strategy.behavior.quack.Quack;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 11:42 AM
 */
public class MallardDuck extends Duck {
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
