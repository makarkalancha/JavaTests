package everything.algorithms.byRobertLafore.ch07;

import everything.algorithms.byRobertLafore.ch03.AbstractSorter;

import java.util.Arrays;

/**
 * User: Makar Kalancha
 * Date: 30/12/2014
 * Time: 14:18
 */
public class Shellsort extends AbstractSorter{
    private int step=1;

    public Shellsort(int[] arr) {
        super(arr);


//        step = 4;
    }

    public static void main(String[] args) {

//        int[] arr = {23, 3, 53, 21, 89, 1};
//        int[] arr = {89, 53, 23, 21, 3, 1};
//        int[] arr = {7, 10, 1, 9, 2, 5, 8, 6, 4, 3};
        int[] arr = {24, 38, 2, 14, 8, 23, 23, 12, 36, 12, 21, 8, 8, 10, 39, 11, 24, 19, 32, 29};
//        int[] arr = {32, 0, 33, 35, 4, 36, 37, 6, 7, 10, 12, 13, 14, 15, 17, 20, 22, 23, 28, 30};
        Shellsort is = new Shellsort(arr);
        is.displayArray();

        is.sort();

        is.displayArray();
    }

    @Override
    public void sort() {
        while (step <= _array.length / 3) {
            step = step * 3 + 1;
            System.out.println("step:" + step);
        }

        int out, in, tmp;
        while (step > 0) {
            for (out = step; out < _array.length; out++) {
                System.out.println();
                System.out.println(">>" + out);
                System.out.println(Arrays.toString(_array));
                ++loopCount;
                tmp = _array[out];
                in = out;
                while (in > step-1 && _array[in - step] >= tmp) {
                    System.out.println(">>>" + in);
                    ++swapCount;
                    _array[in] = _array[in - step];
                    in -= step;
                }
                _array[in] = tmp;
            }
            step = (step - 1) / 3;
        }
    }
}
