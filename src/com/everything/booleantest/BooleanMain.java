package com.everything.booleantest;

/**
 * Created by mcalancea on 2015-04-01.
 */
public class BooleanMain {
    public static void main(String[] args) {
//        Boolean first = false;
//        Boolean second = null;
//        Boolean third = null;
//        boolean result1 = first || second && third;
//        System.out.println(result1);
//
////        boolean test1;
////        System.out.println(test1);
////        test1 = false;
////        System.out.println(test1);

        System.out.println("====and===");
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);
        System.out.println("====or====");
        System.out.println(!true || !true);
        System.out.println(!true || !false);
        System.out.println(!false || !true);
        System.out.println(!false || !false);
    }
}
