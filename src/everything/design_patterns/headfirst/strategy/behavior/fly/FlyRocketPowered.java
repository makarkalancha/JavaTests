package everything.design_patterns.headfirst.strategy.behavior.fly;

/**
 * User: Makar Kalancha
 * Date: 18/07/14
 * Time: 11:50 AM
 */
public class FlyRocketPowered implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
