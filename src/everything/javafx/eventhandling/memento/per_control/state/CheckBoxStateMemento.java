package everything.javafx.eventhandling.memento.per_control.state;

import everything.javafx.eventhandling.memento.per_control.State;
import everything.javafx.eventhandling.memento.per_control.StateMemento;


/**
 * User: Makar Kalancha
 * Date: 10/04/2016
 * Time: 01:24
 */
public class CheckBoxStateMemento implements StateMemento<Boolean> {
    private final State<Boolean> state;

    public CheckBoxStateMemento(String propertyFieldName, Boolean value) {
        this.state = new State<>(propertyFieldName, value);
        System.out.println("CheckBoxStateMemento.constructor:" + state);
    }

    @Override
    public State<Boolean> getState() {
        System.out.println("CheckBoxStateMemento.getState:" + state);
        return state;
    }

    @Override
    public String toString() {
        return "CheckBoxStateMemento{" +
                "state=" + state +
                '}';
    }
}
