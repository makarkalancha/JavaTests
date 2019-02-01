package com.everything.algorithms;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Makar Kalancha
 * Date: 12/03/14
 * Time: 10:41 AM
 */
public class CompareSearch{
    private static SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss:SS");
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        LinearSearch linearSearch = new LinearSearch();
        int _needle = 100;
        System.out.println(_sdf.format(new Date()) + ": find needle = " + _needle);


        System.out.println("Binary Search vs Linear Search");
        System.out.println(_sdf.format(new Date()) + ": _hayStackManual");
        Integer[] _hayStackManual = {1, 2, 5, 8, 10, 33, 64, 80, 100};
        System.out.println(binarySearch.find(_hayStackManual, _needle));
        System.out.println(linearSearch.find(_hayStackManual, _needle));

        System.out.println("===============================================");

        System.out.println(_sdf.format(new Date())+": _hayStackBigLoop");
        Integer[] _hayStackBigLoop = new Integer[100];
        for (int i = 0; i < _hayStackBigLoop.length; i++) {
            _hayStackBigLoop[i] = i + 1;
        }
        System.out.println(binarySearch.find(_hayStackBigLoop, _needle));
        System.out.println(linearSearch.find(_hayStackBigLoop, _needle));

        System.out.println("===============================================");
    }
}
