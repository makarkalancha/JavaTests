package everything.design_patterns.headfirst.state.states;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 12:57 PM
 */
public interface State {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}
