package everything.algorithms.byRobertLafore.ch03;

/**
 * User: Makar Kalancha
 * Date: 19/12/2014
 * Time: 15:09
 */
public class InsertionSort extends AbstractSorter{
    public InsertionSort(int[] arr) {
        super(arr);
    }

    public static void main(String[] args) {
//        int[] arr = {23, 3, 53, 21, 89, 1};
//        int[] arr = {89, 53, 23, 21, 3, 1};
//        int[] arr = {7, 10, 1, 9, 2, 5, 8, 6, 4, 3};
//        int[] arr = {24, 38, 2, 14, 8, 23, 23, 12, 36, 12, 21, 8, 8, 10, 39, 11, 24, 19, 32, 29};
        int[] arr = {32, 0, 33, 35, 4, 36, 37, 6, 7, 10, 12, 13, 14, 15, 17, 20, 22, 23, 28, 30};
        InsertionSort is = new InsertionSort(arr);
        is.displayArray();

        is.sort();

        is.displayArray();
    }

    @Override
    public void sort() {
        int out, in, tmp;
        for (out = 0; out < _array.length; out++) {
            ++loopCount;
            tmp = _array[out];
            in = out;
            while (in > 0 && _array[in - 1] > tmp) {
                ++swapCount;
                _array[in] = _array[in - 1];
                --in;
            }
            _array[in] = tmp;
        }
    }
}
