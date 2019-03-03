package com.everything.design_patterns.tests.memento;

/**
 * User: Makar Kalancha
 * Date: 09/04/2016
 * Time: 23:37
 */
public class MementoDemo {
    public static void main(String[] args) {
        CakeTaker c = new CakeTaker();
        Originator o = new Originator();

        o.setState("State 1");
        o.setState("State 2");
        c.saveState(o.saveState());
        o.setState("State 3");
        o.setState("State 4");
        c.saveState(o.saveState());

        o.restoreState(c.getState(0));

    }
}
