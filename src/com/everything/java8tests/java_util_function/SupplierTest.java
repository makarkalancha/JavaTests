package com.everything.java8tests.java_util_function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by mcalancea on 2015-11-24.
 */
public class SupplierTest {
    //https://blog.idrsolutions.com/2015/03/java-8-consumer-supplier-explained-in-5-minutes/
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Jeremy");
        names.add("Paul");
        names.add("Richard");

        names.stream()
                .forEach(name -> {
                    printNames(()-> name);
                });
    }

    public static void printNames(Supplier<String> arg){
        System.out.println(arg.get());
    }

}

