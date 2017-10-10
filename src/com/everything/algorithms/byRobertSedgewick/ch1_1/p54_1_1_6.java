package com.everything.algorithms.byRobertSedgewick.ch1_1;

/**
 * User: Makar Kalancha
 * Date: 08/05/14
 * Time: 11:02 AM
 */
public class p54_1_1_6 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for(int i = 0 ;i<=15;i++){
//            System.out.println(i+") "+f);
            int f_ex = f;
            int g_ex = g;
            f=f+g;
            g=f-g;
            System.out.println(i+") f_ex="+f_ex+"; g_ex="+g_ex+"; f="+f+"; g="+g);
        }
    }
}
