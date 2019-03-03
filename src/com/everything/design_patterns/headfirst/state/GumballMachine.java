package com.everything.design_patterns.headfirst.state;

import com.everything.design_patterns.headfirst.state.states.HasQuarterState;
import com.everything.design_patterns.headfirst.state.states.NoQuarterState;
import com.everything.design_patterns.headfirst.state.states.SoldOutState;
import com.everything.design_patterns.headfirst.state.states.SoldState;
import com.everything.design_patterns.headfirst.state.states.State;
import com.everything.design_patterns.headfirst.state.states.WinnerState;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 12:59 PM
 */
public class GumballMachine {
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State winnerState;


    private int count = 0;
    private State state = soldState;

    public GumballMachine(int number) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = number;
        if(number > 0) {
            state = noQuarterState;
        }
    }

    public void setState(State state){
        this.state = state;
    }

    public void releaseBall(){
        if(count != 0){
            System.out.println("A gumball comes out the slot...");
            count--;
        }
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
    }

    public void dispense(){
        state.dispense();
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "count=" + count +
                ", state=" + state +
                '}';
    }
}
