package com.everything.algorithms.byRobertSedgewick.ch1_1;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p58_1_1_20 {

    public static void main(String[] args) {
        System.out.println("factorial="+factorial(5));
        System.out.println("lnFacotorial="+lnFacotorial(5));
    }

    private static double lnFacotorial(int num){
        return Math.log(factorial(num));
    }

    private static long factorial(int num){
        if(num == 1) return 1;
        return num * factorial(--num);
    }
}
