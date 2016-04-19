package everything.java8tests.localdate;

import java.time.LocalDate;

/**
 * Created by mcalancea on 2016-04-19.
 */
public class LocalDateDemo {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        System.out.println(localDate.toString());
    }

}
