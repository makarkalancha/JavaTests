package com.everything.java8tests.functionalprogramming.ch07.factorial;

import java.math.BigInteger;

/**
 * Created by mcalancea on 2015-10-08.
 */
public class Factorial {
    public static int factorialRec1(int number){
        if(number == 1){
            return number;
        } else {
            return number * factorialRec1(number - 1);
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static TailCall<Integer> factorialTailRec2(final int factorial, final int number){
        if(number == 1) {
            return TailCalls.done(factorial);
        } else {
            return TailCalls.call(() ->
                    factorialTailRec2(factorial * number, number - 1));
        }
    }

    private static int factorial2(final int number) {
        return factorialTailRec2(1, number).invoke();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static TailCall<BigInteger> factorialTailRec3(final BigInteger factorial, final BigInteger number){
        if(number.equals(BigInteger.ONE)) {
            return TailCalls.done(factorial);
        }else {
            return TailCalls.call(() -> factorialTailRec3(factorial.multiply(number), number.subtract(BigInteger.ONE)));
        }
    }

    public static BigInteger factorial3(final int number) {
        return factorialTailRec3(BigInteger.ONE, BigInteger.valueOf(number)).invoke();
    }

    public static void main(String[] args) {
//        System.out.println(factorialRec1(5));

//        try{
//            System.out.println(factorialRec1(20_000));
//        }catch (StackOverflowError ex){
//            ex.printStackTrace();
//        }

        System.out.println("============2==============================");
        System.out.println(factorial2(5));
        System.out.println(factorial2(20_000));

        System.out.println("============3==============================");
        System.out.println(factorial3(5));
        System.out.println(String.format("%.20s...",factorial3(20_000)));

    }

}
