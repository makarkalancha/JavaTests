package everything.java8tests.optional;

import java.util.Optional;

/**
 * Created by mcalancea on 2016-04-14.
 */
public class OptionalTest {

    public static void main(String[] args) {
//throws exception java.lang.NullPointerException
        Optional<Integer> num1 = Optional.of(null);
        System.out.println(num1);

        //returns Optional.empty
        Optional<Integer> num2 = Optional.ofNullable(null);
        System.out.println(num2);
    }

}
