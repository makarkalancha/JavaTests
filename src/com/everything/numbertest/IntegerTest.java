package com.everything.numbertest;

/**
 * Created by Makar Kalancha
 * Date: 14 Aug 2017
 * Time: 16:02
 */
public class IntegerTest {
    public static void main(String[] args) {
//        int a = 2;
//        int b = 3;
//        System.out.println(b / a);
//
//        System.out.println(Long.valueOf(Integer.MAX_VALUE) + 1);
//
//        long c = Long.valueOf(Integer.MAX_VALUE) + 1;
//        System.out.println("long, not int:" + c);
//        String longAsString = Long.toString(Long.valueOf(Integer.MAX_VALUE) + 1);
////        System.out.println(Integer.parseInt(longAsString));
////        System.out.println(Integer.parseUnsignedInt(longAsString));
////
//        System.out.println(NumberUtils.toInt(longAsString));
//        System.out.println(NumberUtils.toLong(longAsString));




//        long d = Integer.MIN_VALUE + 1;
//        String longAsString_1 = Long.toString(d);
//        System.out.println(Integer.parseInt(longAsString_1));
//        System.out.println(Integer.parseUnsignedInt(longAsString_1));
//
//        System.out.println(NumberUtils.toInt(longAsString_1));

        int totalElements = 7;
        int size = 4;
        int maxIndex = 0;

        Double indexAsDouble = Math.max(Math.ceil((double) totalElements / size) - 1, 0);
        maxIndex = indexAsDouble.intValue();
        System.out.println(maxIndex);
    }
}
