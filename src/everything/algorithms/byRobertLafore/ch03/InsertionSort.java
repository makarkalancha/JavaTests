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
        int[] arr = {23, 3, 53, 21, 89, 1};
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
