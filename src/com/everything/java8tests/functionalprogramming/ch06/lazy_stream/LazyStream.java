package com.everything.java8tests.functionalprogramming.ch06.lazy_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by mcalancea on 2015-10-08.
 */
public class LazyStream {
    public static int length(final String name){
        System.out.println("getting length for "+name);
        return name.length();
    }

    public static String toUpperCase(final String name){
        System.out.println("converting to upper case: "+name);
        return name.toUpperCase();
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe", "Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");

        System.out.println("++++++++++++++LAZY 1+++++++++++++++++++++++++");
        doItLazy1(names);

        System.out.println("++++++++++++++LAZY 2+++++++++++++++++++++++++");
        doItLazy2(names);



    }

    public static void doItLazy2(List<String> names){
        Stream<String> namesStream = names.stream()
                .filter(name -> length(name) == 3)
                .map(name -> toUpperCase(name));
        System.out.println("Stream created, filtered, mapped...");
        System.out.println("ready to call findFirst...");

        final String firstNameWith3Letters = namesStream
                .findFirst()
                .get();
        System.out.println(firstNameWith3Letters);
    }

    public static void doItLazy1(List<String> names){
        final String firstNameWith3Letters = names.stream()
                .filter(name -> length(name) == 3)
                .map(name -> toUpperCase(name))
                .findFirst()
                .get();
        System.out.println(firstNameWith3Letters);
    }
}
