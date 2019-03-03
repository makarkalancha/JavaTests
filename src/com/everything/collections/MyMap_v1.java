package com.everything.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 27/01/14
 * Time: 2:54 PM
 */
public class MyMap_v1 {
    public static void main(String[] args) {
        String nullStr = null;
        String a = "a";
        StringBuffer hash = new StringBuffer();
        hash.append(nullStr);
        hash.append(a);
        System.out.println(hash.hashCode());
        System.out.println(hash.toString().hashCode());

        Map<String, String> m = new HashMap<String, String>();
        m.put("1", "one");
        m.put("2", "two");
        m.put("3", "three");
        m.put("4", "four");
        m.put("5", "five");
        m.put("6", "six");
        System.out.println("---------initial:");
        printMap(m);
        Set<String> valDel = new HashSet<String>();
        valDel.add("three");
        valDel.add("five");
        System.out.println("---------after deletion:");
        m.values().removeAll(valDel);
        printMap(m);
    }

    public static <K,V> void printMap(Map<K,V> m){
        for(Map.Entry<K,V> iter : m.entrySet()){
            System.out.println(iter.getKey()+": "+iter.getValue());
        }
    }
}
