package everything.java8tests.lambda;


import java.nio.channels.Pipe;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Makar Kalancha
 * Date: 05 Oct 2016
 * Time: 14:55
 */
public class FlatMapDemo {
    public static void main(String[] args) {
        Person a = new Person("a", LocalDate.of(2016, Month.JANUARY, 1), Person.Sex.MALE, "a@a.com");
        Person b = new Person("b", LocalDate.of(2015, Month.DECEMBER, 12), Person.Sex.MALE, "b@b.com");
        Person c = new Person("c", LocalDate.of(2014, Month.NOVEMBER, 2), Person.Sex.MALE, "c@c.com");
        Person d = new Person("d", LocalDate.of(2013, Month.OCTOBER, 14), Person.Sex.MALE, "d@d.com");
        Person e = new Person("e", LocalDate.of(2012, Month.SEPTEMBER, 25), Person.Sex.MALE, "e@e.com");
        Person f = new Person("f", LocalDate.of(2011, Month.AUGUST, 6), Person.Sex.MALE, "f@f.com");
        Person g = new Person("g", LocalDate.of(2010, Month.JULY, 17), Person.Sex.MALE, "g@g.com");

        Set<Person> group1 = new HashSet<>();
        group1.add(a);
        group1.add(b);
        group1.add(c);
        group1.add(d);

        Set<Person> group2 = new HashSet<>();
        group2.add(d);
        group2.add(e);
        group2.add(f);

        Set<Person> group3 = new HashSet<>();
        group3.add(f);
        group3.add(g);

        PersonGroup personGroup1 = new PersonGroup(1L, group1);
        PersonGroup personGroup2 = new PersonGroup(2L, group2);
        PersonGroup personGroup3 = new PersonGroup(3L, group3);

        List<PersonGroup> personGroupList = new ArrayList<>();
        personGroupList.add(personGroup1);
        personGroupList.add(personGroup2);
        personGroupList.add(personGroup3);


        Set<Person> personList = personGroupList.stream()
                .map(personGroup -> personGroup.getPersons())
                .flatMap(persons -> persons.stream())
                .collect(Collectors.toSet());
        System.out.println(personList.size());
        personList.forEach(System.out::println);

        Set<Person> personList1 = personGroupList.stream()
                .flatMap(personGroup -> personGroup.getPersons().stream())
                .collect(Collectors.toSet());
        System.out.println(personList1.size());
        personList1.forEach(System.out::println);

        Person person = personGroupList.stream()
                .flatMap(personGroup -> personGroup.getPersons().stream())
                .filter(person1 -> person1.getName().equals("a"))
                .findFirst()
                .orElse(null);
        System.out.println();
        System.out.println("person with name \"a\":" + person);
    }

}
