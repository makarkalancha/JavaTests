package com.everything;

/**
 * User: Makar Kalancha
 * Date: 08/09/14
 * Time: 3:25 PM
 */
public class StatEventExperiment {
    public static void main(String[] args) {
//        int newId = 30_000;
//        int newId = 499_999;
//        int newId = 500_000;
//        int newId = 520_000;
        int newId = 999_999;
//        int newId = 1_000_000;

        System.out.println("prefix:"+getTablePrefix(newId));
        getMinMaxByPrefix(getTablePrefix(newId));
    }

    public static int getTablePrefix(int newId){
        int result = 0;
        int step = 500_000;
        result = newId / step+1;

        return result;
    }

    public static void getMinMaxByPrefix(int prefix) {
        int step = 500_000;
        int max = step * prefix;
        int min = max - step;

        System.out.println("min: "+min+"; max: "+max);
    }


    private static class MinMax{
        public int min;
        public int max;
    }
}
