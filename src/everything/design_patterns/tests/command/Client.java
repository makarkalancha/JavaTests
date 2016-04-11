package everything.design_patterns.tests.command;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class Client {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        //switch on
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();

        //switch off
        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();
    }

}
