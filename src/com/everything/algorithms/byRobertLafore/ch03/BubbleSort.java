package com.everything.algorithms.byRobertLafore.ch03;

/**
 * User: Makar Kalancha
 * Date: 19/12/2014
 * Time: 14:20
 */
public class BubbleSort extends AbstractSorter{

    public BubbleSort(int[] array) {
        super(array);
    }

    public static void main(String[] args) {
        int[] arr = {23, 3, 53, 21, 89, 1};
        BubbleSort bs = new BubbleSort(arr);
        bs.displayArray();

        bs.sort();

        bs.displayArray();
    }

    @Override
    public void sort(){
        int out;
        int in;
        for(out = _array.length-1;out > 0;out--){
            for(in = 0; in < out;in++) {
                ++loopCount;
                if (_array[in] > _array[in + 1]) {
                    swap(in, in + 1);
                }
            }
        }

    }
}
