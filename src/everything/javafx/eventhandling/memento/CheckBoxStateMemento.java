package everything.javafx.eventhandling.memento;

import everything.javafx.eventhandling.StateMemento;


/**
 * User: Makar Kalancha
 * Date: 10/04/2016
 * Time: 01:24
 */
public class CheckBoxStateMemento implements StateMemento<Boolean> {
    private final Boolean state;

    public CheckBoxStateMemento(Boolean s){
        this.state = s;
        System.out.println("CheckBoxStateMemento.constructor:" + state);
    }

    @Override
    public Boolean getState() {
        System.out.println("CheckBoxStateMemento.getState:" + state);
        return state;
    }
}
