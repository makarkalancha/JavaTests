package com.everything.java8tests.functionalprogramming.ch04.interface_default;

/**
 * Created by mcalancea on 2015-09-22.
 */
public interface Fly {
    default void takeOff(){
        System.out.println("Fly::takeOff");
    }

    default void land(){
        System.out.println("Fly::land");
    }

    default void turn(){
        System.out.println("Fly::turn");
    }

    default void cruise(){
        System.out.println("Fly::cruise");
    }
}
