package com.everything.java8tests.forimpatient.ch03;

import java.util.function.IntConsumer;
import java.util.function.Supplier;

/**
 * User: Makar Kalancha
 * Date: 17/02/2015
 * Time: 15:04
 */
public class DemoAppCh03 {
    public static void main(String[] args) {
//        System.out.println("func001: supplier");
//        func001();

        System.out.println("func002: choosing functional interface");
        func002();
    }

    public static void func002(){
        repeat1(3, (i)->System.out.println("-->"+i));
    }

    public static void repeat2(int n, Runnable runnable) {
        for (int i = 0; i < n; i++) {
            runnable.run();
        }
    }

    public static void repeat1(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) {
            action.accept(i);
        }
    }

    public static void func001(){
//        String variable = null;
        String variable = "world";
        info(variable, () -> "hello: "+variable);
    }

    public static void info(String string, Supplier<String> message){
        if(string != null){
            System.out.println(message.get());
        }
    }
}
