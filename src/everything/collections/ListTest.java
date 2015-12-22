package everything.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by mcalancea on 2015-12-22.
 */
public class ListTest {
    enum DayOfWeek{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
//        Preconditions


        Map<DayOfWeek, List<Integer>> testList = new HashMap<>();
        Objects.requireNonNull(testList);
//        System.out.println(!testList.get(DayOfWeek.FRIDAY).isEmpty());//null pointer
        System.out.println(
                !testList.isEmpty() && !testList.get(DayOfWeek.FRIDAY).isEmpty()
        );
//        System.out.println(
//                testList.isEmpty() && testList.get(DayOfWeek.FRIDAY).isEmpty()
//        );
        testList.put(DayOfWeek.MONDAY, Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(
                !testList.isEmpty() && testList.get(DayOfWeek.FRIDAY) != null && !testList.get(DayOfWeek.FRIDAY).isEmpty()
        );

        testList.put(DayOfWeek.FRIDAY, Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(
                !testList.isEmpty() && !testList.get(DayOfWeek.FRIDAY).isEmpty()
        );

        System.out.println(testList);
    }
}
