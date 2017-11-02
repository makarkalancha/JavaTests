package com.everything.strings;

/**
 * Created by Makar Kalancha
 * Date: 01 Nov 2017
 * Time: 09:40
 */
public class StringFormatTest {
    public static void main(String[] args) {
        int one =1;
        String two = "2";
        System.out.println(String.format("hello %1s and %2s", one, two));
    }
}
