package everything.javafx.eventhandling;

import everything.javafx.eventhandling.storage.DequeStack;
import everything.javafx.eventhandling.storage.Stack;

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
//        System.out.println(source + "->currentState is null:" + (currentState == null));
//        System.out.println(source + "->undoStates is empty:"+(undoStates.isEmpty()));
//        System.out.println(source + "->redoStates is empty:"+(redoStates.isEmpty()));
    }

    public void saveState(StateMemento<V> state){
        log("saveState");
        if(currentState != null) {
            undoStates.push(currentState);
            redoStates.clear();
        }
        currentState = state;
    }

    public V undoState(){
        log("undoState");
        V result = null;
        if(!undoStates.isEmpty()){
            redoStates.push(currentState);
            currentState = undoStates.pop();
            result = currentState.getState();
        }
        return result;
    }

    public V redoState(){
        log("redoState");
        V result = null;
        if(!redoStates.isEmpty()){
            undoStates.push(currentState);
            currentState = redoStates.pop();
            result = currentState.getState();
        }
        return result;
    }
}
