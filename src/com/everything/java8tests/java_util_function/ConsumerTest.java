package com.everything.java8tests.java_util_function;

import java.util.function.Consumer;

/**
 * Created by mcalancea on 2015-11-24.
 */
public class ConsumerTest {
    //https://blog.idrsolutions.com/2015/03/java-8-consumer-supplier-explained-in-5-minutes/
    public static void main(String[] args) {
        Consumer<String> consumer = ConsumerTest::printNames;
        consumer.accept("Jeremy");
        consumer.accept("Paul");
        consumer.accept("Richard");
    }

    public static void printNames(String name){
        System.out.println(name);
    }

}
