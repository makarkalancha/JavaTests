package com.everything.design_patterns.headfirst.state.states;

import com.everything.design_patterns.headfirst.state.GumballMachine;

import java.util.Random;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 12:58 PM+
 */
public class HasQuarterState implements State {
    Random random = new Random(System.currentTimeMillis());
    GumballMachine gumballMachine;
    public HasQuarterState(GumballMachine gm){
        this.gumballMachine = gm;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You cannot insert another quarter.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = random.nextInt(10);
        if((winner == 0) && (gumballMachine.getCount() > 1)){
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else{
            gumballMachine.setState(gumballMachine.getSoldState());
        }
        gumballMachine.dispense();
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public String toString() {
        return "HasQuarterState";
    }
}
