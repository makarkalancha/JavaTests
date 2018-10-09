package com.everything.collections;

import com.everything.validation.entity.Student;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by mcalancea
 * Date: 17 May 2018
 * Time: 13:09
 */
public class TableMultiMultiMapTest {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("first1", "second1", 1, 1, 1980),
                new Student("first2", "second2", 1, 1, 1980),
                new Student("first3", "second3", 2, 1, 1980),
                new Student("first4", "second4", 2, 1, 1980),
                new Student("first5", "second5", 4, 1, 1980)
        );
        Multimap<Integer, Student> multimap1 = students.stream()
                .collect(
                        HashMultimap::create,
                        (map, element) -> map.put(element.getMonthOfBirth(), element),
                        (map1, map2) -> map1.putAll(map2));

        for(Map.Entry<Integer, Student> entry : multimap1.entries()){
            System.out.println(entry.getValue());
        }

//        Table<Integer, Integer, Set<Student>> studentTable = multimap1.entries().stream()
//                .collect(
//                        HashBasedTable::create,
//                        (map, element) -> map.put(element.getValue().getDayOfBirth(), element.getValue().getMonthOfBirth(), element),
//                        (map1, map2) -> map1.putAll(map2)
//                );

//        System.out.println(studentTable);
//        System.out.println(studentTable.get(1, 1));
    }
}
