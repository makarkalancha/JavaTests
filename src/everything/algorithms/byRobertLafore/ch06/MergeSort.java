package everything.algorithms.byRobertLafore.ch06;

import everything.algorithms.byRobertLafore.ch03.AbstractSorter;

/**
 * User: Makar Kalancha
 * Date: 19/12/2014
 * Time: 16:23
 */
public class MergeSort extends AbstractSorter {
    private int mergeCount;
    private int recursiveMergeCount;

    public MergeSort(int[] arr) {
        super(arr);
    }

    public static void main(String[] args) {
        int[] arr = {23, 3, 53, 21, 89, 1};
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
            if (_array[lowPtr] < _array[highPtr]) {
                workSpace[j++] = _array[lowPtr++];
            } else {
                workSpace[j++] = _array[highPtr++];
            }
        }

        while (lowPtr <= mid) {
            workSpace[j++] = _array[lowPtr++];
        }

        while (highPtr <= upperBound) {
            workSpace[j++] = _array[highPtr++];
        }

        for (j = 0; j < n; j++) {
            _array[lowerBound + j] = workSpace[j];
        }
    }
}
