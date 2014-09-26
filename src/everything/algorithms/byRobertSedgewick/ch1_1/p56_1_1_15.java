package everything.algorithms.byRobertSedgewick.ch1_1;

import java.util.Arrays;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p56_1_1_15 {

    public static void main(String[] args) {
        int[] array = {0, 2, 1, 4, 3};
        int m = 5;
        System.out.println("array: "+Arrays.toString(array));
        System.out.println("m:"+m);
        int[] tmp = histogram(array, m);
        System.out.println("tmp: "+Arrays.toString(tmp));
    }

    private static int[] histogram(int[] array, int m){
        int[] result = new int[m];
        for(int i = 0 ; i < array.length;i++) {
            int num = array[i];
            if(num < m) {
                result[num]++;
            }
        }

        return result;
    }

}
