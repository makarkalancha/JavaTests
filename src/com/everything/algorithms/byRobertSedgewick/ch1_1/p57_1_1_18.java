package com.everything.algorithms.byRobertSedgewick.ch1_1;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p57_1_1_18 {

    public static void main(String[] args) {
        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 11));

        System.out.println(mystery1(2, 25));
        System.out.println(mystery1(3, 11));
    }

    private static int mystery(int a,int b){
//        System.out.println(a+";"+b);
        if(b==0) return 0;
        if(b%2 == 0) return mystery(a + a, b / 2);
//        if(b%2 == 0) mystery(a + a, b / 2);
//        System.out.println("---+"+a);
        return mystery(a + a, b / 2) + a;
    }

    private static int mystery1(int a,int b){
//        System.out.println(a+";"+b);
        if(b==0) return 1;
        if(b%2 == 0) return mystery1(a * a, b / 2);
//        if(b%2 == 0) mystery(a + a, b / 2);
//        System.out.println("---*"+a);
        return mystery1(a * a, b / 2) * a;
    }
}
