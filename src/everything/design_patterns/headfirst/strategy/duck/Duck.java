package everything.design_patterns.headfirst.strategy.duck;

import everything.design_patterns.headfirst.strategy.behavior.fly.FlyBehavior;
import everything.design_patterns.headfirst.strategy.behavior.quack.QuackBehavior;

/**
 * User: Makar Kalancha
 * Date: 17/07/14
 * Time: 4:27 PM
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck(){}

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void swim(){
        System.out.println("All duck float, even decoys!!!");
    }

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public abstract void display();
}
