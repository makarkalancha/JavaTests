package com.everything.design_patterns.headfirst.state.states;

import com.everything.design_patterns.headfirst.state.GumballMachine;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 12:58 PM+
 */
public class NoQuarterState implements State {
    GumballMachine gumballMachine;
    public NoQuarterState(GumballMachine gm){
        this.gumballMachine = gm;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter.");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    @Override
    public String toString() {
        return "NoQuarterState";
    }
}
