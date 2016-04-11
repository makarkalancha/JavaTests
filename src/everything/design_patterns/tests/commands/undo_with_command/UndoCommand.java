package everything.design_patterns.tests.commands.undo_with_command;

/**
 * Created by mcalancea on 2016-04-11.
 */
public interface UndoCommand {
    void execute();
    void undo();
}
