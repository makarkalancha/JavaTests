package com.everything;

/**
 * Created by Makar Kalancha
 * Date: 19 Jun 2017
 * Time: 11:51
 */
public class LongTest {
    public static void main(String[] args) {
//        Long one = 128L;
//        Long two = 128L;
//        Long three = 127L;
//        long four = 128L;
//        System.out.println(one);
//        if(one == two){
//            System.out.println(one +"=="+ two);
//        }else {
//            System.out.println(one +"!="+ two);
//        }
//
////        if(one == three){
////            System.out.println(one +"=="+ three);
////        }else {
////            System.out.println(one +"!="+ three);
////        }
//
//        if(one == four){
//            System.out.println(four +"=="+ four);
//        }else {
//            System.out.println(four +"!="+ four);
//        }
//////////////////////////////////////////
//        if(one.equals(two)){
//            System.out.println(one +" equals "+ two);
//        }else {
//            System.out.println(one +" !equals "+ two);
//        }
//
////        if(one.equals(three)){
////            System.out.println(one +" equals "+ three);
////        }else {
////            System.out.println(one +" !equals "+ three);
////        }
//
//        if(one.equals(four)){
//            System.out.println(one +" equals "+ four);
//        }else {
//            System.out.println(one +" !equals "+ four);
//        }
//
//        Long notNull = new Long(2);
//        Long nullLong = null;
//        getLong(notNull);
//        getLong(nullLong.longValue());

//        Long countFact = 2L;
//        long countExpected = 1L;
//        System.out.println(countFact.compareTo(countExpected) == 1);

        long one = 1L;
        long two = new Long(Integer.MAX_VALUE);
        long three = one + two;
        System.out.println("max:\r\n" + Integer.MAX_VALUE);
        System.out.println(three);

    }

    public static void getLong(long primitiveLong){
        System.out.println(primitiveLong);
    }
}
