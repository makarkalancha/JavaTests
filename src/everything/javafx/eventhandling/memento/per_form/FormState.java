package everything.javafx.eventhandling.memento.per_form;

/**
 * Created by mcalancea on 2016-04-12.
 */
public class FormState {
    private final String textfield;
    private final boolean checkbox;

    public FormState(String textfield, boolean checkbox){
        this.textfield = textfield;
        this.checkbox = checkbox;
    }

    public boolean getCheckboxValue() {
        return checkbox;
    }

    public String getTextfieldValue() {
        return textfield;
    }

    @Override
    public String toString() {
        return "FormState{" +
                "checkbox=" + checkbox +
                ", textfield='" + textfield + '\'' +
                '}';
    }
}
