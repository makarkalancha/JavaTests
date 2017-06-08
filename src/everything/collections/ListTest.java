package everything.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mcalancea on 2015-12-22.
 */
public class ListTest {
    enum DayOfWeek{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
////        Preconditions
//        Map<DayOfWeek, List<Integer>> testList = new HashMap<>();
//        Objects.requireNonNull(testList);
////        System.out.println(!testList.get(DayOfWeek.FRIDAY).isEmpty());//null pointer
//        System.out.println(
//                !testList.isEmpty() && !testList.get(DayOfWeek.FRIDAY).isEmpty()
//        );
////        System.out.println(
////                testList.isEmpty() && testList.get(DayOfWeek.FRIDAY).isEmpty()
////        );
//        testList.put(DayOfWeek.MONDAY, Arrays.asList(1, 2, 3, 4, 5, 6));
//        System.out.println(
//                !testList.isEmpty() && testList.get(DayOfWeek.FRIDAY) != null && !testList.get(DayOfWeek.FRIDAY).isEmpty()
//        );
//
//        testList.put(DayOfWeek.FRIDAY, Arrays.asList(1, 2, 3, 4, 5, 6));
//        System.out.println(
//                !testList.isEmpty() && !testList.get(DayOfWeek.FRIDAY).isEmpty()
//        );
//
//        System.out.println(testList);

        List<Integer> listOne = new ArrayList<>();
        listOne.add(1);
        listOne.add(2);
        listOne.add(3);
        listOne.add(4);

//        List<Integer> listTwo = null;

        List<Integer> listTwo = new ArrayList<>();
        listTwo.add(5);
        listTwo.add(6);
        listTwo.add(7);
        listTwo.add(8);

//        List<Integer> listTwo_1 = new ArrayList<>();
//        listTwo_1.addAll(listTwo);
//        System.out.println(listTwo_1);

        List<Integer> listThree = new ArrayList<>();
        listThree.add(9);
        listThree.add(10);
        listThree.add(11);
        listThree.add(12);
        listThree.add(13);

        List<Integer> onePlusTwo = joinLists(listOne, listTwo, listThree);
//        List<Integer> onePlusTwo = joinLists(listOne, listTwo);
        System.out.println(onePlusTwo);
    }

    public static <E> List<E> joinLists(List<E> listOne, List<E> listTwo){
        if(listOne == null){
            listOne = new ArrayList<>();
        }

        if(listTwo == null){
            listTwo = new ArrayList<>();
        }

        return  Stream
                .concat(new ArrayList<>(listOne).stream(),new ArrayList<>(listTwo).stream())
                .collect(Collectors.toList());
    }

    public static <E> List<E> joinLists(List<E> listOne, List<E> listTwo, List<E>... moreLists){
        List<E> result = joinLists(listOne, listTwo);
        for(List<E> list : moreLists){
            result = joinLists(result, list);
        }
        return result;
    }
}
