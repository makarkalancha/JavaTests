package everything.algorithms.byRobertLafore.ch06;

/**
 * User: Makar Kalancha
 * Date: 18/12/2014
 * Time: 15:29
 */
public class RecursiveBinarySearch {
    private int _count=0;
    private final int[] _haystack;
    private final int _needle;

    public RecursiveBinarySearch(int[] haystack, int needle) {
        this._haystack = haystack;
        this._needle = needle;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 6, 8, 10, 15, 26, 39, 59, 69, 74, 85, 99, 100};
//        int needle = 4;
//        System.out.println(find(array,needle));
        for(int i = 0 ; i < array.length ; i++) {
            System.out.println("Looking for: "+array[i]);
            RecursiveBinarySearch search = new RecursiveBinarySearch(array, array[i]);
            System.out.println(search.find());
            System.out.println();
        }
        int needle = 55;
        System.out.println("Looking for: "+needle);
        RecursiveBinarySearch searchFail = new RecursiveBinarySearch(array, needle);
        System.out.println(searchFail.find());
        System.out.println();

        needle = 0;
        System.out.println("Looking for: "+needle);
        searchFail = new RecursiveBinarySearch(array, needle);
        System.out.println(searchFail.find());
        System.out.println();

        needle = 105;
        System.out.println("Looking for: "+needle);
        searchFail = new RecursiveBinarySearch(array, needle);
        System.out.println(searchFail.find());
        System.out.println();

    }

//    public int find(int[] haystack, int needle) {
//        return find(haystack, needle, 0, haystack.length - 1);
//    }

    public int find() {
        return find(_haystack, _needle, 0, _haystack.length - 1);
    }

    public int find(int[] haystack, int needle, int lowerBound, int higherBound){
        int result = -1;

        int current = (higherBound + lowerBound) /2;
        System.out.println("step " + (++_count));

        if(haystack[current] == needle) {
            return current;
        } else if(lowerBound >= higherBound) {
            return result;
        } else if(needle > haystack[current]) {
            return find(haystack, needle, current + 1, higherBound);
        } else if(needle < haystack[current]) {
            return find(haystack, needle, lowerBound, current - 1);
        }

        return result;
    }
}
