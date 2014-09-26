package everything.design_patterns.headfirst.state.states;

import everything.design_patterns.headfirst.state.GumballMachine;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 12:58 PM+
 */
public class WinnerState implements State {
    GumballMachine gumballMachine;
    public WinnerState(GumballMachine gm){
        this.gumballMachine = gm;
    }

    @Override
    public void insertQuarter() {
        System.err.println("ERROR: no insert quarter");
    }

    @Override
    public void ejectQuarter() {
        System.err.println("ERROR: no eject quarter");
    }

    @Override
    public void turnCrank() {
        System.err.println("ERROR: no turn crank");
    }

    @Override
    public void dispense() {
        System.out.println("YOU ARE A WINNER! You get two gumballs for your quarter");
        gumballMachine.releaseBall();
        if(gumballMachine.getCount() == 0){
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else{
            gumballMachine.releaseBall();
            if(gumballMachine.getCount() > 0){
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }

    @Override
    public String toString() {
        return "WinnerState";
    }
}
