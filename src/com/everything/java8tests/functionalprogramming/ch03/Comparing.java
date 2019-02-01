package com.everything.java8tests.functionalprogramming.ch03;


import com.everything.java8tests.functionalprogramming.Person;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * User: Makar Kalancha
 * Date: 17/01/2016
 * Time: 23:02
 */
public class Comparing {
    public static void main(String[] args) {
        final List<Person> people = Arrays.asList(
                new Person("John", 20),
                new Person("Sara", 21),
                new Person("Jane", 21),
                new Person("Greg", 35));

        final Function<Person, Integer> byAge = person -> person.getAge();
        final Function<Person, String> byTheirName = person -> person.getName();
        printPeople("Sorted in ascending order of age and name: ",
                people.stream()
                        .sorted(Comparator.comparing(byAge).thenComparing(byTheirName))
                        .collect(Collectors.toList()));
    }

    public static void printPeople(final String message, final List<Person> people) {
        System.out.println(message);
        people.forEach(System.out::println);
    }
}
