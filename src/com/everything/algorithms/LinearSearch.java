package com.everything.algorithms;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Makar Kalancha
 * Date: 06/03/14
 * Time: 1:14 PM
 */
public class LinearSearch extends Search {
    private static SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss:SS");

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        int _needle = 100;
        System.out.println(_sdf.format(new Date()) + ": find needle = " + _needle);


        System.out.println(_sdf.format(new Date()) + ": _hayStackManual");
        Integer[] _hayStackManual = {1, 2, 5, 8, 10, 33, 64, 80, 100};
        System.out.println(linearSearch.find(_hayStackManual, _needle));

        System.out.println("===============================================");

        System.out.println(_sdf.format(new Date()) + ": _hayStackBigLoop");
        Integer[] _hayStackBigLoop = new Integer[100];
        for (int i = 0; i < _hayStackBigLoop.length; i++) {
            _hayStackBigLoop[i] = i + 1;
        }
        System.out.println(linearSearch.find(_hayStackBigLoop, _needle));

        System.out.println("===============================================");

//        System.out.println(LOG_TIME_FORMAT.format(new Date())+": _hayStackReallyBigRandom");
//        int sizeOfHayStackReallyBigRandom = 1_000_000;
//        Integer[] _hayStackReallyBigRandom = new Integer[sizeOfHayStackReallyBigRandom];
//        TreeSet<Integer> treeSetInteger = new TreeSet<Integer>();
//        Random random = new Random();
//        int randomEnd = 10_000_000;
//        while(treeSetInteger.size() < _hayStackReallyBigRandom.length) {
//            treeSetInteger.add(random.nextInt(randomEnd));
//        }
//        System.out.println(LOG_TIME_FORMAT.format(new Date())+": end of filling the set");
//        _hayStackReallyBigRandom = treeSetInteger.toArray(new Integer[_hayStackReallyBigRandom.length]);
////        System.out.println(Arrays.toString(_hayStackReallyBigRandom));
//        System.out.println(linearSearch.find(_hayStackReallyBigRandom, _needle));
//
//        System.out.println(LOG_TIME_FORMAT.format(new Date())+": end!!!");


    }

    public int find(Integer[] hayStack, int needle){
        System.out.println(_sdf.format(new Date())+": start linear search");
        Date start = new Date();
        int i = 0;
        for(; i< hayStack.length ; i++) {
//            System.out.println(LOG_TIME_FORMAT.format(new Date())+": step #"+i);
            if (hayStack[i] == needle){
                System.out.println(_sdf.format(new Date())+": stop linear search; index = "+i);
                Date end = new Date();
                timeSpeed(start,end);
                return i;
            }
        }
        System.out.println(_sdf.format(new Date())+": stop linear search; no needle");
        Date end = new Date();
        timeSpeed(start,end);
        return -1;
    }
}
