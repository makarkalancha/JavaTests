package com.everything.java8tests.functionalprogramming.ch06.lazy_infinite_streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mcalancea on 2015-10-08.
 */
public class PrimeNumbers {
    public static boolean isPrime(final int number) {
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(divisor -> number % divisor == 0);
    }

    private static int primeAfter(final int number){
        if(isPrime(number+1)) {
            return number + 1;
        } else {
            return primeAfter(number + 1);
        }
    }

    public static List<Integer> primes(final int fromNumber, final int count){
        return Stream.iterate(primeAfter(fromNumber-1), PrimeNumbers::primeAfter)
                .limit(count).collect(Collectors.<Integer>toList());
    }

    public static void main(String[] args) {
        List<Integer> result = primes(1, 10);
        System.out.println(result);
    }

//    public static List<Integer> concat(final int number1, final int number2){
//
//    }
//
//    public static List<Integer> primes(final int number){
//        if(isPrime(number)){
//            return concat
//        }
//    }
}
