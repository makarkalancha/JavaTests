package com.everything.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mcalancea
 * Date: 08/02/2019
 * Time: 10:13
 */
public class ListToSubList {
    public static void main(String[] args) {
        int afterIndex = 2;
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 2));
        System.out.println(list1);

        List<Integer> subList1 = new ArrayList<>();
        if (afterIndex < list1.size()) {
            subList1 = new ArrayList<>(list1.subList(afterIndex, list1.size()));
        }

        System.out.println(subList1);
    }
}
