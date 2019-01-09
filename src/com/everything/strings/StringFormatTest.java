package com.everything.strings;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Makar Kalancha
 * Date: 01 Nov 2017
 * Time: 09:40
 */
public class StringFormatTest {
    public static void main(String[] args) {
//        test001();
        test002();
    }

    public static void test002(){
        List<String> otherVertices = Arrays.asList("one", "two", "three");
        HashMap<String, Integer> labels = new HashMap<>();
        labels.put("one", 1);

//        String tmp1 = String.format("One or many vertices to process aren\'t found : %s" + Sets.difference(ImmutableSet.copyOf(otherVertices), ImmutableSet.copyOf(labels.keySet())), new Object[0]);
        String tmp1 = String.format("One or many vertices to process aren\'t found : %s", Sets.difference(ImmutableSet.copyOf(otherVertices), ImmutableSet.copyOf(labels.keySet())));
        System.out.println(tmp1);
    }

    public static void test001(){
        int one = 1;
        String two = "2";
        System.out.println(String.format("hello %1s and %2s", one, two));
    }
}
