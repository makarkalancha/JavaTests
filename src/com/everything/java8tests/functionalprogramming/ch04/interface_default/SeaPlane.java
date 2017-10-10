package com.everything.java8tests.functionalprogramming.ch04.interface_default;

/**
 * Created by mcalancea on 2015-09-22.
 */
public class SeaPlane extends Vehicle implements FastFly, Sail {
    private int altitude;

    public SeaPlane(int a){
        this.altitude = a;
    }

    @Override
    public void cruise() {
        System.out.print("SeaPlane::cruise currently cruise like: ");
        if (altitude > 0) {
            FastFly.super.cruise();
        } else {
            Sail.super.cruise();
        }
    }
}
