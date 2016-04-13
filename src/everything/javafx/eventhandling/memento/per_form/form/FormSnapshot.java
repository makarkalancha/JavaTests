package everything.javafx.eventhandling.memento.per_form.form;

import java.util.HashSet;
import java.util.Set;
import javafx.beans.property.Property;

/**
 * Created by mcalancea on 2016-04-13.
 */
public class FormSnapshot {
    private Set<Element> elements = new HashSet<>();

    public void addElement(Element stateMemento) {
        elements.add(stateMemento);
    }
    public Element getElementByProperty(Property property){
        return elements.stream()
                .filter(element -> element.getProperty().equals(property))
                .findFirst()
                .get();
    }
    public Element getElementByPropertyName(String propertyName){
        return elements.stream()
                .filter(element -> element.getPropertyName().equals(propertyName))
                .findFirst()
                .get();
    }

    @Override
    public String toString() {
        return "FormSnapshot{" +
                "elements=" + elements +
                '}';
    }
}
