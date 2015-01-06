package everything.algorithms.byRobertLafore.utils;

import java.util.*;

/**
 * User: Makar Kalancha
 * Date: 30/12/2014
 * Time: 16:08
 */
public class Generator {
    public static void main(String[] args) {
        int[] arr = randomArray(20);
        System.out.println(Arrays.toString(arr));
        int[] arrUnique = randomUniqueArray(20);
        System.out.println(Arrays.toString(arrUnique));
    }


    public static int[] randomArray(int length) {
        Random random = new Random();
        int max = length * 2;
        List<Integer> list = new ArrayList<>();
        while (list.size() < length) {
            list.add(random.nextInt(max));
        }
        return intCollectionToArray(list);
    }

    public static int[] randomUniqueArray(int length) {
        Random random = new Random();
        int max = length * 2;
        Set<Integer> set = new HashSet<>();
        while (set.size() < length) {
            set.add(random.nextInt(max));
        }
        return intCollectionToArray(set);
    }

    public static int[] intCollectionToArray(Collection<Integer> collection) {
        int [] result = new int[collection.size()];
        int i = 0;
        for (Integer val : collection){
            result[i] = val;
            i++;
        }
        return result;
    }
}
