package everything.javafx.eventhandling.memento.per_form;

import everything.javafx.eventhandling.memento.per_form.form.FormSnapshot;
import everything.javafx.eventhandling.storage.DequeStack;
import everything.javafx.eventhandling.storage.Stack;

/**
 * User: Makar Kalancha
 * Date: 11/04/2016
 * Time: 23:30
 */
public class UndoFormCakeTaker<V>{
    private Stack<FormSnapshot> undoStates = new DequeStack<>();
    private Stack<FormSnapshot> redoStates = new DequeStack<>();
    private FormSnapshot currentState;

    private void log(String source){
        System.out.println("======================================================");
        System.out.println("UndoCakeTaker." + source + "->currentState:" + currentState);
        System.out.println("UndoCakeTaker." + source + "->undoStates:" + undoStates);
        System.out.println("UndoCakeTaker." + source + "->redoStates:" + redoStates);
        System.out.println("======================================================");
    }

    public void saveState(FormSnapshot state){
        log("saveState: before if");
        if(currentState != null) {
            undoStates.push(currentState);
            redoStates.clear();
        }
        currentState = state;
        log("saveState: after if");
    }

    public FormSnapshot undoState(){
        log("undoState: before if");
        FormSnapshot result = null;
        if(currentState != null) {
            redoStates.push(currentState);
        }
        if(!undoStates.isEmpty()){
            currentState = undoStates.pop();
            System.out.println("getState from UndoCakeTaker.undoState");
            result = currentState;
        } else {
            currentState = null;
        }
        log("undoState: after if");
        return result;
    }

    public FormSnapshot redoState(){
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
        return currentState;
    }
}
