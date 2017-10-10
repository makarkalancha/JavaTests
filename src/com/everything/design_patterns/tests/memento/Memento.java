package com.everything.design_patterns.tests.memento;

/**
 * User: Makar Kalancha
 * Date: 09/04/2016
 * Time: 23:23
 */
public class Memento {
    private String state;
    public Memento(String s){
        this.state = s;
    }

    public String getState(){
        return state;
    }
}
