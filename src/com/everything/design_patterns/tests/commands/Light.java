package com.everything.design_patterns.tests.commands;

/**
 * Created by mcalancea on 2016-04-11.
 */
public class Light {
    private boolean isOn;

    public boolean isOn() {
        return isOn;
    }

    public void switchOn() {
        isOn = true;
        System.out.println("ligth is on");
    }

    public void switchOff() {
        isOn = false;
        System.out.println("ligth is off");
    }

}
