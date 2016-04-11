package everything.design_patterns.tests.commands.undo_with_command;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class CommandManager {
    private UndoCommand lastCommand;

    public CommandManager(){

    }

    public void executeCommand(UndoCommand command){
        command.execute();
        lastCommand = command;
    }

    public void undo(){
        if(lastCommand != null){
            lastCommand.undo();
            lastCommand = null;
        }
    }

}
