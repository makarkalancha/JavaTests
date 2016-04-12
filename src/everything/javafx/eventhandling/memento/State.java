package everything.javafx.eventhandling.memento;

/**
 * Created by mcalancea on 2016-04-12.
 */
public class State <V> {
    private final String propertyFieldName;
    private final V value;

    public State(String propertyFieldName, V value){
        this.propertyFieldName = propertyFieldName;
        this.value = value;
    }

    public String getPropertyFieldName() {
        return propertyFieldName;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "State{" +
                "propertyFieldName='" + propertyFieldName + '\'' +
                ", value=" + value +
                '}';
    }
}
