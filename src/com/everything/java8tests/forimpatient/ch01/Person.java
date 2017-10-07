package com.everything.java8tests.forimpatient.ch01;

/**
 * User: Makar Kalancha
 * Date: 30/01/2015
 * Time: 16:55
 */
public interface Person {
    long getId();
    default String getName() {
        return "John Q. Public";
    }
}
