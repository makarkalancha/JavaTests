package com.everything.algorithms.byRobertLafore.ch07;

import com.everything.algorithms.byRobertLafore.ch03.AbstractSorter;

/**
 * User: Makar Kalancha
 * Date: 30/12/2014
 * Time: 14:18
 */
public class MyShellsort extends AbstractSorter{
    private int step=1;

    public MyShellsort(int[] arr) {
        super(arr);


//        step = 4;
    }

    public static void main(String[] args) {

//        int[] arr = {23, 3, 53, 21, 89, 1};
//        int[] arr = {89, 53, 23, 21, 3, 1};
//        int[] arr = {7, 10, 1, 9, 2, 5, 8, 6, 4, 3};
        int[] arr = {24, 38, 2, 14, 8, 23, 23, 12, 36, 12, 21, 8, 8, 10, 39, 11, 24, 19, 32, 29};
//        int[] arr = {32, 0, 33, 35, 4, 36, 37, 6, 7, 10, 12, 13, 14, 15, 17, 20, 22, 23, 28, 30};
        MyShellsort is = new MyShellsort(arr);
        is.displayArray();

        is.sort();

        is.displayArray();
    }

    @Override
    public void sort() {
        int tmpStep = 1;
        while (tmpStep < _array.length) {
            tmpStep = tmpStep * 3 + 1;
            System.out.println("tmpStep:"+tmpStep);
        }
        step = (tmpStep - 1) / 3;

        int initial, out, in, tmp;
//        for (; step > 0; step--) {
//        for (; step > 0; step=(step - 1) / 3) {
        while (step > 0) {
//////            if(step <= 0){
//////                step = 1;
//////            }
//            boolean result = step > 0;
//            System.out.println(result);
            System.out.println("-->" + step);
            for (initial = 0; initial < _array.length; initial++) {
                System.out.println();
                System.out.println(">" + initial);
                for (out = initial; out < _array.length; out += step) {
                    System.out.println(">>" + out);
                    ++loopCount;
                    tmp = _array[out];
                    in = out;
                    while (in > initial && _array[in - step] > tmp) {
                        System.out.println(">>>" + in);
                        ++swapCount;
                        _array[in] = _array[in - step];
                        in -= step;
                    }
                    _array[in] = tmp;
                }
            }
            step = (step - 1) / 3;
        }
    }
}
