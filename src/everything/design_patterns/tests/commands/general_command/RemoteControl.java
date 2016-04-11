package everything.design_patterns.tests.commands.general_command;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class RemoteControl {
    private GeneralCommand generalCommand;

    public void pressButton () {
        generalCommand.execute();
    }

    public void setGeneralCommand(GeneralCommand generalCommand) {
        this.generalCommand = generalCommand;
    }
}
