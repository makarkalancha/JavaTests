package everything.design_patterns.headfirst.state.states;

import everything.design_patterns.headfirst.state.GumballMachine;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 12:58 PM+
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;
    public SoldOutState(GumballMachine gm){
        this.gumballMachine = gm;
    }

    @Override
    public void insertQuarter() {
        System.err.println("ERROR: No gumballs, don't insert quarter");
    }

    @Override
    public void ejectQuarter() {
        System.err.println("ERROR: No gumballs, no eject quarter");
    }

    @Override
    public void turnCrank() {
        System.err.println("ERROR: No gumballs, no turn crank quarter");
    }

    @Override
    public void dispense() {
        System.err.println("ERROR: No gumballs, no dispense quarter");
    }

    @Override
    public String toString() {
        return "SoldOutState";
    }
}
