package com.everything.design_patterns.tests.commands.undo_with_command;

import com.everything.design_patterns.tests.commands.Light;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class Client {

    public static void main(String[] args) {
        CommandManager commandManager = new CommandManager();
        Light light = new Light();
        UndoCommand lightOn = new LightOnUndoCommand(light);
        UndoCommand lightOff = new LightOffUndoCommand(light);

        //switch on
        commandManager.executeCommand(lightOn);
        System.out.println("light.isOn():" + light.isOn());

        //switch off
        commandManager.executeCommand(lightOff);
        System.out.println("light.isOn():" + light.isOn());
        commandManager.undo();
        System.out.println("light.isOn():" + light.isOn());
    }

}
