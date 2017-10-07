package com.everything.java8tests.optional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Created by mcalancea on 2016-04-14.
 */
public class OptionalTest {

    public static void main(String[] args) {
//throws exception java.lang.NullPointerException
//        Optional<Integer> num1 = Optional.of(null);
//        System.out.println(num1);
//
//        //returns Optional.empty
//        Optional<Integer> num2 = Optional.ofNullable(null);
//        System.out.println(num2);

        // if the value is not present
        Optional<Car> carOptionalEmpty = Optional.empty();
        carOptionalEmpty
                .filter( x -> "250".equals( x.getPrice() ) )
                .ifPresent( x -> System.out.println("1-"+ x.getPrice() + " is ok!" ) );

        // if the value does not pass the filter
        Optional<Car> carOptionalExpensive = Optional.of( new Car( "3333" ) );
        carOptionalExpensive
                .filter(x -> "250".equals(x.getPrice()))
                .ifPresent(x -> System.out.println("2-" + x.getPrice() + " is ok!"));

        // if the value is present and does pass the filter
        Optional<Car> carOptionalOk = Optional.of( new Car( "250" ) );
        carOptionalOk
                .filter(x -> "250".equals(x.getPrice()))
                .ifPresent(x -> System.out.println("3-" + x.getPrice() + " is ok!"));

        Set<Integer> integers = new HashSet<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(5);

        integers.stream()
                .filter(i -> i.equals(4))
                .findFirst()
                .ifPresent(i -> System.out.println("1-"+i));

        integers.stream()
                .filter(i -> i.equals(5))
                .findFirst()
                .ifPresent(i -> System.out.println("2-"+i));
    }

    private static class Car{
        private final String price;

        public Car(String price) {
            this.price = price;
        }

        public String getPrice() {
            return price;
        }
    }
}
