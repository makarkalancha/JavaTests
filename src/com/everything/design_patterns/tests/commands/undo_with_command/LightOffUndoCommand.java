package com.everything.design_patterns.tests.commands.undo_with_command;

import com.everything.design_patterns.tests.commands.Light;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class LightOffUndoCommand implements UndoCommand{
    private boolean wasOn;
    private final Light light;

    public LightOffUndoCommand(Light l){
        this.light = l;
    }

    @Override
    public void execute() {
        this.wasOn = this.light.isOn();
        this.light.switchOff();
    }

    @Override
    public void undo() {
        System.out.println("undo");
        if (wasOn){
            this.light.switchOn();
        } else {
            this.light.switchOff();
        }
    }
}
