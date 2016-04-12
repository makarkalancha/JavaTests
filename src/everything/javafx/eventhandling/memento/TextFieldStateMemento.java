package everything.javafx.eventhandling.memento;

import everything.javafx.eventhandling.StateMemento;


/**
 * User: Makar Kalancha
 * Date: 10/04/2016
 * Time: 01:24
 */
public class TextFieldStateMemento implements StateMemento<String> {
    private final String state;

    public TextFieldStateMemento(String s){
        this.state = s;
        System.out.println("TextFieldStateMemento.constructor:" + state);
    }

    @Override
    public String getState() {
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
