package everything.design_patterns.headfirst.strategy.behavior.fly;

/**
 * User: Makar Kalancha
 * Date: 17/07/14
 * Time: 4:31 PM
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fly with wings.");
    }
}
