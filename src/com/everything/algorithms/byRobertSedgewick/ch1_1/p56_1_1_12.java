package com.everything.algorithms.byRobertSedgewick.ch1_1;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p56_1_1_12 {
    public static void main(String[] args) {
        //display 1
        int[] a = new int[10];
        System.out.println("First:");
        for (int i = 0; i < a.length; i++) {
            a[i]=9-i;
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("Second:");
        for (int i = 0; i < a.length; i++) {
            a[i] = a[a[i]];
            System.out.print(a[i] + " ");
        }
    }
}
