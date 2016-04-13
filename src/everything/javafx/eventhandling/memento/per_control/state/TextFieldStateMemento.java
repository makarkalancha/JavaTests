package everything.javafx.eventhandling.memento.per_control.state;

import everything.javafx.eventhandling.memento.per_control.State;
import everything.javafx.eventhandling.memento.per_control.StateMemento;

/**
 * User: Makar Kalancha
 * Date: 10/04/2016
 * Time: 01:24
 */
public class TextFieldStateMemento implements StateMemento<String> {
    private final State<String> state;

    public TextFieldStateMemento(String propertyFieldName, String value){
        this.state = new State<>(propertyFieldName, value);
        System.out.println("TextFieldStateMemento.constructor:" + state);
    }

    @Override
    public State<String> getState() {
        System.out.println("TextFieldStateMemento.getState:" + state);
        return state;
    }

    @Override
    public String toString() {
        return "TextFieldStateMemento{" +
                "state='" + state + '\'' +
                '}';
    }
}
