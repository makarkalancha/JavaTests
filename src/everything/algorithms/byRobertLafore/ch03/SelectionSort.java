package everything.algorithms.byRobertLafore.ch03;

/**
 * User: Makar Kalancha
 * Date: 19/12/2014
 * Time: 14:37
 */
public class SelectionSort extends AbstractSorter{
    public SelectionSort(int[] arr) {
        super(arr);
    }

    public static void main(String[] args) {
        int[] arr = {23, 3, 53, 21, 89, 1};
        SelectionSort ss = new SelectionSort(arr);
        ss.displayArray();

        ss.sort();

        ss.displayArray();
    }

    @Override
    public void sort() {
        int min, out ,in;
//        array length = 7
//        loopCount:15
//        swapCount:8
        for (out = 0; out < _array.length; out++) {
            min = out;
            for (in = out + 1; in < _array.length; in++) {
                ++loopCount;
                if (_array[min] > _array[in]) {
                    swap(min, in);
                }
            }
        }

////        loopCount == swapCount
//        for (out = 0; out < _array.length-1; out++) {
//            min = out;
//            for (in = out + 1; in < _array.length; in++) {
//                ++loopCount;
//                if (_array[min] > _array[in]) {
//                    min = in;
//                }
//                swap(out, min);
//            }
//        }
    }
}
