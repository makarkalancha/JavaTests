package com.everything.javafx.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 28/12/2017
 * Time: 22:26
 */
public class ListRemoveDemo {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();

        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        integerList.add(a);
        integerList.add(b);
        integerList.add(c);
        integerList.add(d);
        integerList.add(b);
        System.out.println(integerList);

//        integerList.remove(2);//removes index
        integerList.remove(new Integer(2));//removes first int with 2
        System.out.println(integerList);
    }
}
