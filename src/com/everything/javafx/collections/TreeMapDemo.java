package com.everything.javafx.collections;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mcalancea
 * Date: 25 Jan 2018
 * Time: 14:48
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("one", 1);
        treeMap.put("two", 2);

        System.out.println(treeMap);

        System.out.println(treeMap.get("one"));
        System.out.println(treeMap.get("one1"));
//        System.out.println(treeMap.get(null));
    }
}
