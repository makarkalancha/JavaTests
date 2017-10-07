package com.everything.algorithms;

import java.util.Arrays;

/**
 * User: Makar Kalancha
 * Date: 25/08/14
 * Time: 4:14 PM
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] intArray = {1, 12, 5, 26, 7, 14, 3, 7, 2};
//        int[] intArray = {5, 1, 12, -5, 16};
        System.out.println(Arrays.toString(intArray));

        System.out.println(Arrays.toString(SelectionSort.sortMy(intArray)));
//        System.out.println(Arrays.toString(SelectionSort.sortShort(intArray)));
    }

    public static int[] sortMy(int[] array){
        for(int i = 0 ; i < array.length ; i++){
            System.out.println(">>>loop");
            int minIndex=i;
//            for(int j = minIndex ; j < array.length;j++){
            for(int j = minIndex+1 ; j < array.length;j++){
                System.out.println(">>>comparison");
                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                System.out.println(">>>swap");
                HolderT<Integer> holderT = new HolderT<>(array[i], array[minIndex]);
                array[i] = holderT.getSecond();
                array[minIndex] = holderT.getFirst();
            }
        }

        return array;
    }

    public static int[] sortShort(int[] array) {
        int i,j,minIndex;
        int n = array.length;
        for(i = 0 ; i < n-1 ; i++){
            System.out.println(">>>loop");
            minIndex = i;
            for(j = i+1 ; j < n ; j++){
                System.out.println(">>>comparison");
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            if(minIndex != i){
                System.out.println(">>>swap");
                HolderT<Integer> holderT = new HolderT<>(array[i], array[minIndex]);
                array[i] = holderT.getSecond();
                array[minIndex] = holderT.getFirst();
            }
        }
        return array;
    }
}
