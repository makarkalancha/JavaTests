package everything.algorithms.byRobertLafore.ch07;

import everything.algorithms.byRobertLafore.ch03.AbstractSorter;

/**
 * User: Makar Kalancha
 * Date: 05/01/2015
 * Time: 11:18
 */
public class Partition  extends AbstractSorter{
    private int _pivot;

    public Partition(int[] arr) {
        super(arr);
    }

    public static void main(String[] args) {

//        int[] arr = {23, 3, 53, 21, 89, 1};
//        int[] arr = {89, 53, 23, 21, 3, 1};
//        int[] arr = {7, 10, 1, 9, 2, 5, 8, 6, 4, 3};
        int[] arr = {24, 38, 2, 14, 8, 23, 23, 12, 36, 12, 21, 8, 8, 10, 39, 11, 24, 19, 32, 29};
//        int[] arr = {32, 0, 33, 35, 4, 36, 37, 6, 7, 10, 12, 13, 14, 15, 17, 20, 22, 23, 28, 30};
        Partition partition = new Partition(arr);
        partition.displayArray();

        partition.partitionIt(0, arr.length - 1);

        partition.displayArray();
    }

    private int getAverage(int left, int right){
        int sum = 0;
        for(int i = left ; i <= right ; i++) {
            sum += _array[i];
        }
        return sum / (right - left + 1);
    }

    public int partitionIt(int left, int right) {
        _pivot = getAverage(left,right);
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            ++loopCount;
            while (leftPtr < right && _array[++leftPtr] < _pivot) ;
            while (rightPtr > left && _array[--rightPtr] > _pivot) ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        return leftPtr;
    }

    protected int partitionForQuickSort(int left, int right, int pivot) {
        _pivot = pivot;
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            ++loopCount;
            while (_array[++leftPtr] < _pivot) ;
            while (rightPtr > 0 && _array[--rightPtr] > _pivot) ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right);
        return leftPtr;
    }

    protected int partitionForQuickSort2(int left, int right, int pivot) {
        _pivot = pivot;
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true) {
            ++loopCount;
            while (_array[++leftPtr] < _pivot) ;
            while (_array[--rightPtr] > _pivot) ;
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(leftPtr, rightPtr);
            }
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    @Override
    public void sort() {

    }
}
