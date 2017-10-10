package com.everything.algorithms.byRobertLafore.ch03;

/**
 * User: Makar Kalancha
 * Date: 19/12/2014
 * Time: 14:37
 */
public abstract class AbstractSorter {
    protected final int[] _array;
    protected int loopCount;
    protected int swapCount;
    public AbstractSorter(int[] array) {
        this._array = array;
    }

    public void displayArray(){
        System.out.println("length:"+_array.length);
        System.out.println("loopCount:"+loopCount);
        System.out.println("swapCount:"+swapCount);
        for(int i : _array){
            System.out.print(i + "\t\t");
        }
        System.out.println();
    }

    protected void swap(int one, int two) {
        ++swapCount;
        int tmp = _array[one];
        _array[one] = _array[two];
        _array[two] = tmp;
    }

    public abstract void sort();
}
