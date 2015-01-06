package everything.algorithms.byRobertLafore.ch07;

/**
 * User: Makar Kalancha
 * Date: 05/01/2015
 * Time: 15:17
 */
public class QuickSort2 extends Partition{
    public QuickSort2(int[] arr) {
        super(arr);
    }

    public static void main(String[] args) {

//        int[] arr = {23, 3, 53, 21, 89, 1};
//        int[] arr = {89, 53, 23, 21, 3, 1};
//        int[] arr = {7, 10, 1, 9, 2, 5, 8, 6, 4, 3};
//        int[] arr = {24, 38, 2, 14, 8, 23, 23, 12, 36, 12, 21, 8, 8, 10, 39, 11, 24, 19, 32, 29};
//        int[] arr = {32, 0, 33, 35, 4, 36, 37, 6, 7, 10, 12, 13, 14, 15, 17, 20, 22, 23, 28, 30};
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1,};
        QuickSort2 qs2 = new QuickSort2(arr);
        qs2.displayArray();

        qs2.sort();

        qs2.displayArray();
    }

    @Override
    public void sort() {
        quickSort(0, _array.length - 1);
    }

    private void quickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3) {
            manualSort(left, right);
        } else {
            int median = medianOf3(left, right);
            int partition = partitionForQuickSort2(left, right, median);
            quickSort(left, partition - 1);
            quickSort(partition + 1, right);
        }
    }

    private void manualSort(int left, int right) {
        int size = right - left + 1;
        if(size <= 1){
            return;
        }

        if (size == 2) {
            if (_array[left] > _array[right]) {
                swap(left, right);
            }
            return;
        } else {//size == 3
            if (_array[left] > _array[right-1]) {
                swap(left, right-1); //left, center
            }

            if (_array[left] > _array[right]) {
                swap(left, right); //left, right
            }

            if (_array[right-1] > _array[right]) {
                swap(right-1, right); //center, right
            }
        }
    }

    private int medianOf3(int left, int right) {
        int center = (left + right) / 2;

        if (_array[left] > _array[center]) {
            swap(left, center);
        }

        if (_array[left] > _array[right]) {
            swap(left, right);
        }

        if (_array[center] > _array[right]) {
            swap(center, right);
        }

        swap(center, right - 1);
        return _array[right - 1];

    }
}
