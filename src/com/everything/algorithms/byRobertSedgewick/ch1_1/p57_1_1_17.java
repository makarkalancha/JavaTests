package com.everything.algorithms.byRobertSedgewick.ch1_1;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p57_1_1_17 {

    public static void main(String[] args) {
        System.out.println(exR1(6));
    }

    private static String exR1(int num){
        String s = exR1(num - 3) + num + exR1(num - 2) + num;
        if(num <= 0) return "-";
        return s;
    }
}
