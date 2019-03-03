package com.everything.algorithms;

import java.util.Arrays;

/**
 * User: Makar Kalancha
 * Date: 25/08/14
 * Time: 3:47 PM
 */
public class BubbleSort {

    public static void main(String[] args) {
//        int[] intArray = {1, 12, 5, 26, 7, 14, 3, 7, 2};
        int[] intArray = {5, 1, 12, -5, 16};
        System.out.println(Arrays.toString(intArray));

//        System.out.println(Arrays.toString(BubbleSort.sortMy(intArray)));
        System.out.println(Arrays.toString(BubbleSort.sortShort(intArray)));
    }

    public static int[] sortShort(int[] array) {
        boolean swapped = true;
        int j=0;
        while (swapped){
            swapped = false;
            j++;
            System.out.println(">>>recursive");
            for(int i = 0 ; i < array.length-j;i++){
                System.out.println(">>>comparison");
                if(array[i] > array[i+1]){
                    System.out.println(">>>swap");
                    HolderT<Integer> holderT = new HolderT<>(array[i], array[i + 1]);
                    array[i] = holderT.getSecond();
                    array[i+1] = holderT.getFirst();
                    swapped = true;
                }
            }
        }

        return array;
    }

    public static int[] sortMy(int[] array) {
        int swap = 0;
        for(int i = 0;i < (array.length-1);i++){
            System.out.println(">>>comparison");
            if(array[i] > array[i+1]) {
                System.out.println(">>>swap");
                HolderT<Integer> holderT = new HolderT<>(array[i], array[i + 1]);
                array[i] = holderT.getSecond();
                array[i+1] = holderT.getFirst();
                swap++;
            }
        }

        if(swap > 0) {
            System.out.println(">>>recursive");
            array = sortMy(array);

        }
        return array;
    }
}
