package com.everything.design_patterns.tests.commands.general_command;

import com.everything.design_patterns.tests.commands.Light;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class Client {

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        Light light = new Light();
        GeneralCommand lightOn = new LightOnCommand(light);
        GeneralCommand lightOff = new LightOffCommand(light);

        //switch on
        remoteControl.setGeneralCommand(lightOn);
        remoteControl.pressButton();

        //switch off
        remoteControl.setGeneralCommand(lightOff);
        remoteControl.pressButton();
    }

}
