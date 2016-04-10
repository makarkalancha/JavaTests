package everything.javafx.eventhandling.commands;

import everything.javafx.eventhandling.EventCommand;
import javafx.beans.value.ChangeListener;


/**
 * User: Makar Kalancha
 * Date: 10/04/2016
 * Time: 01:24
 */
public class TextFieldCommand implements EventCommand {
    private ChangeListener changeListener;
    public TextFieldCommand(ChangeListener changeListener){
        this.changeListener = changeListener;
    }

    @Override
    public void execute() {
        changeListener.changed();
    }
}
