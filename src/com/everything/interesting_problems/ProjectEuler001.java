package com.everything.interesting_problems;

/**
 * User: Makar Kalancha
 * Date: 29/08/14
 * Time: 2:40 PM
 */


//If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
//Find the sum of all the multiples of 3 or 5 below 1000.


public class ProjectEuler001 {
    public static void main(String[] args) {
//        Set<Integer> integerSet = new HashSet<>();
//        for (int i = 1; i < 1000; i++) {
//            if(i%3 == 0 || i%5 == 0 ) {
//                integerSet.add(i);
//            }
//        }
//
//        int sum=0;
//        for(int integer : integerSet) {
//            sum += integer;
//            System.out.println(integer);
//        }
//
//        System.out.println(">>>sum:"+sum);
//
        int sum=0;
        for (int i = 1; i < 1000; i++) {
            if(i%3 == 0 || i%5 == 0 ) {
                sum+=i;
            }
        }
        System.out.println(">>>sum:"+sum);
    }
}
