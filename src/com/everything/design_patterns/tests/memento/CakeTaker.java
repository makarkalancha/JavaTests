package com.everything.design_patterns.tests.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 09/04/2016
 * Time: 23:28
 */
public class CakeTaker {
    private List<Memento> savedStates = new ArrayList<>();

    public void saveState(Memento m){
        savedStates.add(m);
    }

    public Memento getState(int index){
        return savedStates.get(index);
    }
}
