package com.everything.javafx.collections;

import java.util.TreeSet;

/**
 * User: Makar Kalancha
 * Date: 18/11/2018
 * Time: 01:29
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        String date1 = "2018-10-01'T'23:05'Z'";
        String date2 = "2018-11-10'T'20:05'Z'";
        String date3 = "2018-10-01'T'19:05'Z'";
        String date4 = "2018-11-30'T'05:05'Z'";
        String date5 = "2018-10-01'T'08:05'Z'";

        TreeSet<String> set = new TreeSet();
        set.add(date1);
        set.add(date2);
        set.add(date3);
        set.add(date4);
        set.add(date5);

        System.out.println(set);
        System.out.println("first:" + set.first());
    }
}
