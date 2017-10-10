package com.everything.algorithms.byRobertSedgewick.ch1_1;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p55_1_1_9 {
    public static void main(String[] args) {
        int binaryInt = 156;
        System.out.println(binaryInt);
        String binaryString = Integer.toBinaryString(binaryInt);
        System.out.println(binaryString);

        String s = "";
        for(int n = binaryInt ; n > 0 ; n/=2) {
//            if(n%2 == 0){
//                System.out.print("1");
//            } else{
//                System.out.print("0");
//            }
            s = (n % 2) + s;
            System.out.println(n + ") n="+n+"; n%2=" + (n % 2));
        }
        System.out.println(s);
        System.out.println();

    }
}
