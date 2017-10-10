package com.everything.javafx.eventhandling.memento.per_control;

import com.everything.javafx.eventhandling.storage.DequeStack;
import com.everything.javafx.eventhandling.storage.Stack;

/**
 * User: Makar Kalancha
 * Date: 11/04/2016
 * Time: 23:30
 */
public class UndoCakeTaker <V>{
    private Stack<StateMemento<V>> undoStates = new DequeStack<>();
    private Stack<StateMemento<V>> redoStates = new DequeStack<>();
    private StateMemento<V> currentState;

    private void log(String source){
        System.out.println("======================================================");
        System.out.println("UndoCakeTaker." + source + "->currentState:" + currentState);
        System.out.println("UndoCakeTaker." + source + "->undoStates:" + undoStates);
        System.out.println("UndoCakeTaker." + source + "->redoStates:" + redoStates);
        System.out.println("======================================================");
    }

    public void saveState(StateMemento<V> stateMemento){
        log("saveState: before if");
        if(currentState != null) {
            undoStates.push(currentState);
            redoStates.clear();
        }
        currentState = stateMemento;
        log("saveState: after if");
    }

    public State<V> undoState(){
        log("undoState: before if");
        State<V> result = null;
        if(currentState != null) {
            redoStates.push(currentState);
        }
        if(!undoStates.isEmpty()){
            currentState = undoStates.pop();
            System.out.println("getState from UndoCakeTaker.undoState");
            result = currentState.getState();
        } else {
            currentState = null;
        }
        log("undoState: after if");
        return result;
    }

    public State<V> redoState(){
        log("redoState: before if");
//        V result = null;

        if(!redoStates.isEmpty()){
            if(currentState != null) {
                undoStates.push(currentState);
            }
            currentState = redoStates.pop();
            System.out.println("getState from UndoCakeTaker.redoState");
//            result = currentState.getState();
        }
        log("redoState: after if");
        return currentState.getState();
    }
}
