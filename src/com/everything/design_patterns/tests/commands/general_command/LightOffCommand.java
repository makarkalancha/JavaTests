package com.everything.design_patterns.tests.commands.general_command;

import com.everything.design_patterns.tests.commands.Light;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class LightOffCommand implements GeneralCommand{
    private final Light light;

    public LightOffCommand(Light l){
        this.light = l;
    }

    @Override
    public void execute() {
        this.light.switchOff();
    }
}
