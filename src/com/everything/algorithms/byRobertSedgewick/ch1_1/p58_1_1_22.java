package com.everything.algorithms.byRobertSedgewick.ch1_1;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p58_1_1_22 {
//    private static int recursiveCount = 1;


    public static void main(String[] args) {
        int[] array = {1, 3, 5, 12, 35, 100};
        int needle = 3;
        System.out.println(binarySearch(array,needle));

    }

    public static int binaryRecursiveSearch(int[] hay, int needle) {
        int recursiveCount = 1;
        return binaryRecursiveSearch(hay, needle, 0, hay.length - 1,recursiveCount);
    }

    private static int binaryRecursiveSearch(int[] hay, int needle, int lo,int hi,int count) {
        int mid = (lo + hi) / 2;
        if(hay[mid] == needle) {
            System.out.println(count+") needle is found:"+mid);
            return mid;
        } else if (lo > hi) {
            System.out.println(count+") no result");
            return -1;
        } else if (needle > hay[mid]) {
            lo = mid + 1;
        } else if (needle < hay[mid]) {
            hi = mid - 1;
        }
        System.out.println(count+") recursion low:"+lo+"; high:"+hi);
        return binaryRecursiveSearch(hay, needle, lo, hi,++count);
    }

    public static int binarySearch(int[] hay, int needle) {
        int result = -1;
        int lo = 0;
        int hi = hay.length-1;
        int count = 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(hay[mid] == needle) {
                System.out.println(count+") needle is found:"+mid);
                return mid;
            } else if (needle > hay[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            System.out.println(count+") low:"+lo+"; high:"+hi);
            count++;
        }
        System.out.println("no result");
        return result;
    }

}
