package com.everything.java8tests.forimpatient.ch01;

/**
 * User: Makar Kalancha
 * Date: 30/01/2015
 * Time: 17:05
 */
public interface Named {
    default String getName() {
        return getClass().getName() + "_" + hashCode();
    }
}
