package com.everything.java8tests.functionalprogramming.ch02;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by mcalancea on 2015-07-02.
 */
public class PredicateString {

    private final Function<String,Predicate<String>> checkIfStartsWithField2 = (String letter) -> {
        Predicate<String> predicate = (String name) -> name.startsWith(letter);
        return predicate;
    };

    public static Predicate<String> checkIfStartsWith1(final String letter) {
        return name -> name.startsWith(letter);
    }



    public static void main(String[] args) {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
        final List<String> editors = Arrays.asList("Brian", "Jackei", "John", "Mike");
        final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zack");

        final long countFriendsStartN1 = friends.stream().filter(checkIfStartsWith1("N")).count();
        System.out.println("countFriendsStartN1: "+countFriendsStartN1);

        PredicateString predicateString = new PredicateString();
        final long countFriendsStartN2 = friends.stream().filter(predicateString.checkIfStartsWithField2.apply("N")).count();
        System.out.println("countFriendsStartN2: "+countFriendsStartN2);
    }


}
