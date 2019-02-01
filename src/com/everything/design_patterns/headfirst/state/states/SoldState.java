package com.everything.design_patterns.headfirst.state.states;

import com.everything.design_patterns.headfirst.state.GumballMachine;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 12:58 PM
 */
public class SoldState implements State {
    GumballMachine gumballMachine;
    public SoldState(GumballMachine gm){
        this.gumballMachine = gm;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if(gumballMachine.getCount() > 0){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }

    @Override
    public String toString() {
        return "SoldState";
    }
}
