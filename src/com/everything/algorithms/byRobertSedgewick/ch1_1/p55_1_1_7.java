package com.everything.algorithms.byRobertSedgewick.ch1_1;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p55_1_1_7 {
    public static void main(String[] args) {
        //a
        double t = 9.0;
        while(Math.abs(t-9.0/t) > .001){
            t = (9.0/t+t)/2.0;
        }
        System.out.print("a) ");
        System.out.println(String.format("%.5f",t));

        //b
        int sumB = 0;
        for(int i=1;i<1000;i++){
            for(int j=0;j<i;j++){
                sumB++;
            }
        }
        System.out.print("b) ");
        System.out.println(sumB);

        //с
        int sumC = 0;
        for(int i=1;i<1000;i *= 2){
            for(int j=0;j<i;j++){
                sumC++;
            }
        }
        System.out.print("c) ");
        System.out.println(sumC);
    }
}
