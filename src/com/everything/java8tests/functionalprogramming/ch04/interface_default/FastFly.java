package com.everything.java8tests.functionalprogramming.ch04.interface_default;

/**
 * Created by mcalancea on 2015-09-22.
 */
public interface FastFly extends Fly {
    default void takeOff(){
        System.out.println("FastFly::takeOff");
    }

}
