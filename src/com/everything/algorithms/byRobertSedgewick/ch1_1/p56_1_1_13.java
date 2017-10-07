package com.everything.algorithms.byRobertSedgewick.ch1_1;

import java.util.Random;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p56_1_1_13 {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        //display 1
//        int[][] a = new int[5][];
        int[][] a = new int[3][];
        System.out.println("Normal:");
        ///fill
        fill2DArray(a);

        ////print
        print2DArray(a);

        System.out.println();
        System.out.println("Mirror:");
        mirror2DArray(a);
        print2DArray(a);

        System.out.println();
        System.out.println("Transpose:");
        a = transpose2DArray(a);
        print2DArray(a);
    }

    private static void fill2DArray(int[][] array){

        for (int i = 0; i < array.length; i++) {
            array[i] = new int[3];
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = getPosRandomInt(0,10);
//                array[i][j] = j;
            }
        }
    }
    private static void mirror2DArray(int[][] array){
        int count_mirror = 0;
        for (int i = 0,j=array.length-1; i <= array.length/2 && j >= array.length/2; i++, j--) {
            int length_m = array[i].length;
            int length_n = -1;
            if(i==j) {
                length_m = array[i].length / 2;
                length_n = array[i].length / 2;
            }
            for (int m = 0, n=array[j].length-1; m < length_m && n > length_n; m++, n--) {
                array[i][m] = array[i][m] + array[j][n];
                array[j][n] = array[i][m] - array[j][n];
                array[i][m] = array[i][m] - array[j][n];
                count_mirror++;
            }
        }
        System.out.println("count:" + count_mirror);
    }

    private static int[][] transpose2DArray(int[][] array){
        int count_transpose=0;
        int[][] tmp = new int[array[0].length][];
        for (int j = 0; j < array[0].length; j++) {
            tmp[j] = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                tmp[j][i] = array[i][j];
                count_transpose++;
            }
        }
        System.out.println("count:"+count_transpose);

        return tmp;
    }

    private static void print2DArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t\t");
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
