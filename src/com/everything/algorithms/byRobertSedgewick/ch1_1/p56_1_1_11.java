package com.everything.algorithms.byRobertSedgewick.ch1_1;

import java.util.Arrays;
import java.util.Random;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p56_1_1_11 {
    private static final Random RANDOM = new Random();
    public static void main(String[] args) {
//        boolean[][] array=new boolean[3][];
        boolean[][] array=new boolean[getPosRandomInt(1,5)][];
        //fill

        for(int i = 0 ; i < array.length;i++) {
            array[i] = new boolean[getPosRandomInt(1, 5)];
            for(int j =0 ;j<array[i].length;j++) {
                array[i][j] = (getPosRandomInt(0, 10) > 5) ? true : false;
            }
        }

        for(int i =0;i<array.length;i++){
            System.out.println(Arrays.toString(array[i]));
        }


        //display 1
        for(int i = 0 ; i < array.length;i++){
            for(int j = 0 ; j < array[i].length;j++){
                System.out.print((array[i][j]) ? "*" : "_");
            }
            System.out.println();
        }
    }

    private static int getPosRandomInt(int low, int high){
        if(high > low){
            return RANDOM.nextInt(high)+low;
        } else {
            throw new IllegalArgumentException("Low MUST be less than high!");
        }

    }
}
