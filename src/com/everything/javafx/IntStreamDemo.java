package com.everything.javafx;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * User: Makar Kalancha
 * Date: 18/11/2017
 * Time: 08:43
 */
public class IntStreamDemo {
    public static void main(String[] args) {
        List<Integer> years = IntStream.rangeClosed(2000, 2009).boxed()
                .collect(Collectors.toList());
        System.out.println(years);
    }
}
