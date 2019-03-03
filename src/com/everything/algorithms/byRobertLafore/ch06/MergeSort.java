package com.everything.algorithms.byRobertLafore.ch06;

import com.everything.algorithms.byRobertLafore.ch03.AbstractSorter;

/**
 * User: Makar Kalancha
 * Date: 19/12/2014
 * Time: 16:23
 */
public class MergeSort extends AbstractSorter {
    private int mergeCount;
    private int recursiveMergeCount;
    private int copyCount;
    private int comparisonCount;

    public MergeSort(int[] arr) {
        super(arr);
    }

    public static void main(String[] args) {
//        int[] arr = {23, 3, 53, 21, 89, 1, 11, 49};
        int[] arr = {3, 1, 11,21, 23,49,53, 89};  //min
//        int[] arr = {89, 53, 49, 23, 21, 11, 3, 1}; //max
        MergeSort ms = new MergeSort(arr);
        ms.displayArray();

        ms.sort();

        ms.displayArray();
    }

    @Override
    public void sort() {
        int[] workSpace = new int[_array.length];
        recursiveSort(workSpace, 0, _array.length - 1);
        System.out.println("recursiveMergeCount: "+recursiveMergeCount);
        System.out.println("mergeCount: "+mergeCount);
        System.out.println("copyCount: "+copyCount);
        System.out.println("comparisonCount: "+comparisonCount);

    }

    private void recursiveSort(int[] workSpace, int lowerBound, int upperBound) {
        ++recursiveMergeCount;
        if (upperBound == lowerBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;

            recursiveSort(workSpace, lowerBound, mid);

            recursiveSort(workSpace, mid + 1, upperBound);


            merge(workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(int[] workSpace, int lowPtr, int highPtr, int upperBound) {
        ++mergeCount;

        int j = 0; //workSpace index
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; //# of items

        while (lowPtr <= mid && highPtr <= upperBound) {
            ++comparisonCount;
            if (_array[lowPtr] < _array[highPtr]) {
                workSpace[j++] = _array[lowPtr++];
                ++copyCount;
            } else {
                workSpace[j++] = _array[highPtr++];
                ++copyCount;
            }
        }

        while (lowPtr <= mid) {
            workSpace[j++] = _array[lowPtr++];
            ++copyCount;
        }

        while (highPtr <= upperBound) {
            workSpace[j++] = _array[highPtr++];
            ++copyCount;
        }

        for (j = 0; j < n; j++) {
            _array[lowerBound + j] = workSpace[j];
        }
    }
}
