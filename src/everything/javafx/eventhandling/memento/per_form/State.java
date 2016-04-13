package everything.javafx.eventhandling.memento.per_form;

/**
 * Created by mcalancea on 2016-04-12.
 */
public class State<V> {
    private final V value;

    public State(V value){
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "State{" +
                "value=" + value +
                '}';
    }
}
