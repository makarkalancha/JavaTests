package everything.design_patterns.tests.command;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class RemoteControl {
    private Command command;

    public void pressButton () {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
