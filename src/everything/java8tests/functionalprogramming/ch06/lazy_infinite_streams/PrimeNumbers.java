package everything.java8tests.functionalprogramming.ch06.lazy_infinite_streams;

import java.util.stream.IntStream;

/**
 * Created by mcalancea on 2015-10-08.
 */
public class PrimeNumbers {
    public static boolean isPrime(final int number) {
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(divisor -> number % divisor == 0);
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
