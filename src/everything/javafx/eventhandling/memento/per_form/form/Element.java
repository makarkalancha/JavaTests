package everything.javafx.eventhandling.memento.per_form.form;

import everything.javafx.eventhandling.memento.per_form.StateMemento;
import javafx.beans.property.Property;

/**
 * Created by mcalancea on 2016-04-13.
 */
public class Element<V> {
    private String propertyName;
    private Property property;
    private StateMemento<V> elementState;

    public Element(String propertyName, Property property, StateMemento<V> elementState){
        this.propertyName = propertyName;
        this.property = property;
        this.elementState = elementState;
    }

    public StateMemento<V> getElementState() {
        return elementState;
    }

    public Property getProperty() {
        return property;
    }

    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public String toString() {
        return "Element{" +
                "elementState=" + elementState +
                ", propertyName='" + propertyName + '\'' +
                ", property=" + property +
                '}';
    }
}
