package com.everything.java8tests.forimpatient.ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * User: Makar Kalancha
 * Date: 30/01/2015
 * Time: 14:14
 */
public class DemoAppCh001 {
    public static void main(String[] args) {
        System.out.println("func001");
        DemoAppCh001.func001();
//
//        System.out.println("\nfunc002");
//        DemoAppCh001.func002();
//
//        System.out.println("\nfunc003");
//        DemoAppCh001.func003();

//        System.out.println("\nfunc004: exception in lambda");
//        DemoAppCh001.func004();

//        System.out.println("\nfunc005: reference method ::");
//        DemoAppCh001.func005();

//        System.out.println("\nfunc006: concurrent greeter");
//        DemoAppCh001.func006();

//        System.out.println("\nfunc007: variable scope");
//        DemoAppCh001.func007();

//        System.out.println("\nfunc008: list print");
//        DemoDemoAppCh001.func008();

//        System.out.println("\nfunc009: person interface");
//        DemoDemoAppCh001.func009();

//        System.out.println("\nfunc010: named person interface");
//        DemoDemoAppCh001.func010();

//        System.out.println("\nfunc011: named another person interface");
//        DemoDemoAppCh001.func011();

//        System.out.println("\nfunc012: static method in interface");
//        DemoDemoAppCh001.func012();
    }

    public static void func012() {
//        InterfaceStatic intStat = new InterfaceStatic() {
//            public int getId(){
//                return 23;
//            }
//        };

        System.out.println(InterfaceStatic.getMessage());
//        System.out.println(intStat.getId());
    }

    public static void func011() {
//        Person person = new RealNamedAnotherPerson(20);
//        Person person = new RealNamedAnotherPerson(20, "bebebe");
        Person person = new RealNamedAnotherPerson(20, "123");
        System.out.println(person.getId());
        System.out.println(person.getName());
    }

    public static void func010() {
//        Person person = new RealNamedPerson(20);
//        Person person = new RealNamedPerson(20, "bebebe");
        Person person = new RealNamedPerson(20, "123");
        System.out.println(person.getId());
        System.out.println(person.getName());
    }

    public static void func009() {
//        Person person = new RealPerson(20);
        Person person = new RealPerson(20, "bebebe");
        System.out.println(person.getId());
        System.out.println(person.getName());
    }

    public static void func008() {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("one");
        list.add("hello");
        list.add("123");

        list.forEach(System.out::println);

//        //instead of this:
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
    }

    public static void func007(){
        repeatMessage("hello",3);
    }

    public static void repeatMessage(String text, int count) {
        Runnable runnable = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text+"->"+Thread.currentThread().getName());
                Thread.yield();
            }
        };
        new Thread(runnable).start();
    }

    public static void func006(){
        ConcurrentGreeter cc = new ConcurrentGreeter();
        cc.greet();
    }

    public static void func005() {
        String first = "first";
        String second = "Second";
        String third = "third";
        String fourth = "Fourth";
        String fifth = "fifth";
        String sixth = "Sixth";
        String seventh = "seventh";
        String eighth = "Eighth";
        String[] arrayOfWords = {first, second, third, fourth, fifth, sixth, seventh, eighth};

        System.out.println(Arrays.toString(arrayOfWords));
        Arrays.sort(arrayOfWords, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(arrayOfWords));
    }

    public static void func004() {
        Runnable runnable = ()->{
            try {
                System.out.println("sleepy");
                Thread.sleep(1000);
                System.out.println("sleeping");
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        };
        new Thread(runnable).start();
    }

    public static void func003() {
        BiFunction<String, String, Integer> comp = (first, second) -> Integer.compare(first.length(), second.length());
        System.out.println(comp);
    }

    public static void func002() {
        String first1 = "a";
        String second1 = "ab";
        String third1 = "abc";
        String fourth1 = "abcd";
        String fifth1 = "abcde";
        String sixth1 = "abcdef";
        String seventh1 = "abcdefg";
        String eighth1 = "abcdefgh";
        String[] arrayOfWords1 = {first1, second1, third1, fourth1, fifth1, sixth1, seventh1, eighth1};
        System.out.println(Arrays.toString(arrayOfWords1));
        Arrays.sort(arrayOfWords1, (f, s) -> Integer.compare(s.length(), f.length()));
        System.out.println(Arrays.toString(arrayOfWords1));
    }

    public static void func001() {
        String first = "first";
        String second = "second";

        String third = "third";
        String fourth = "fourth";
        String fifth = "fifth";
        String sixth = "sixth";
        String seventh = "seventh";
        String eighth = "eighth";
        String[] arrayOfWords = {first, second, third, fourth, fifth, sixth, seventh, eighth};

        System.out.println(Integer.compare(first.length(), second.length()));

        System.out.println(Arrays.toString(arrayOfWords));
        Arrays.sort(arrayOfWords, (f, s) -> Integer.compare(f.length(), s.length()));
        System.out.println(Arrays.toString(arrayOfWords));

        System.out.println("Print array");
        Arrays.stream(arrayOfWords).forEach(System.out::println);
    }
}
