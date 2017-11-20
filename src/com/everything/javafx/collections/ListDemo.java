package com.everything.javafx.collections;


import com.everything.javafx.eventhandling.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mcalancea
 * Date: 20 Nov 2017
 * Time: 16:05
 */
public class ListDemo {
    private static Person one = new Person("f1", "l1");
    private static Person two;
    private static Person three;
    private static List<Person> personList = new ArrayList<>();
//    static{
//        personList = Arrays.asList(
//                one,
//                two,
//                three
//        );
//    }

    private void setStrings(Person person){
//        person = new RealPerson(3L, "any");
        person.setFirstName("3fl");
    }

    public static void main(String[] args) {
        ListDemo listDemo = new ListDemo();

        one = new Person("f4L", "not any");
        two = new Person("f4L", "not any");
        three = new Person("f4L", "not any");
        personList = Arrays.asList(
                one,
                two,
                three
        );

        System.out.println(personList);

        for(Person person : personList){
            listDemo.setStrings(person);
        }

        System.out.println(personList);
    }
}
