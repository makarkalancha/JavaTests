package everything.algorithms.byRobertLafore.ch07;

import everything.algorithms.byRobertLafore.ch03.AbstractSorter;

/**
 * User: Makar Kalancha
 * Date: 05/01/2015
 * Time: 15:17
 */
public class QuickSort extends Partition{
    public QuickSort(int[] arr) {
        super(arr);
    }

    public static void main(String[] args) {

//        int[] arr = {23, 3, 53, 21, 89, 1};
//        int[] arr = {89, 53, 23, 21, 3, 1};
//        int[] arr = {7, 10, 1, 9, 2, 5, 8, 6, 4, 3};
//        int[] arr = {24, 38, 2, 14, 8, 23, 23, 12, 36, 12, 21, 8, 8, 10, 39, 11, 24, 19, 32, 29};
//        int[] arr = {32, 0, 33, 35, 4, 36, 37, 6, 7, 10, 12, 13, 14, 15, 17, 20, 22, 23, 28, 30};
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        QuickSort qs = new QuickSort(arr);
        qs.displayArray();

        qs.sort();

        qs.displayArray();
    }

    @Override
    public void sort() {
        quickSort(0, _array.length - 1);
    }

    private void quickSort(int left, int right) {
//        ++loopCount;
        if (right - left <= 0) {
            return;
        } else {
//            int partition = partitionIt(left, right);
            int pivot = _array[right];
            int partition = partitionForQuickSort(left, right, pivot);
            quickSort(left, partition - 1);
            quickSort(partition + 1, right);
        }
    }
}
