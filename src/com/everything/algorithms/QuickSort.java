package com.everything.algorithms;

import java.util.Arrays;

/**
 * User: Makar Kalancha
 * Date: 22/08/14
 * Time: 4:20 PM
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] intArray = {1, 12, 5, 26, 7, 14, 3, 7, 2};
        int[] intArray = {5, 1, 12, -5, 16};
        System.out.println(Arrays.toString(intArray));

        System.out.println(Arrays.toString(QuickSort.sort(intArray)));
    }

    public static int[] sort(int[] array) {
        int left = 0;
        int right = array.length-1;
        return QuickSort.sort(array, left, right);
    }

    private static int[] sort(int[] array, int from , int to) {
        int index = partition(array, from, to);
        if(from < index -1) {
            sort(array, from, index - 1);
        }

        if (index < to) {
            sort(array, index, to);
        }
        return array;
    }

    private static int partition(int[] array, int from, int to){
        int left = from;
        int right = to;
        int pivotNumber = array[(left + right) / 2];
        while (left <= right){
            while(array[left] < pivotNumber) {
                left++;
            }

            while(array[right] > pivotNumber) {
                right--;
            }

            if(left <= right) {
                HolderT<Integer> holder = new HolderT<>(array[left], array[right]);
                array[left] = holder.getSecond();
                array[right] = holder.getFirst();
                left++;
                right--;
            }
        }
        return left;
    }

}
