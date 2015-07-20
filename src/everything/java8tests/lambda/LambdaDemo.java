package everything.java8tests.lambda;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 02/09/14
 * Time: 10:16 AM
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Person person1 = new Person("John", new LocalDate(2010, 1, 1), Person.Sex.MALE, "john@doe.ca");
        Person person2 = new Person("Jack", new LocalDate(1980, 2, 6), Person.Sex.MALE, "jack@smith.ca");
        Person person3 = new Person("Jessica", new LocalDate(1959, 6, 20), Person.Sex.FEMALE, "jessica@pollak.ca");
        Person person4 = new Person("Elizabeth", new LocalDate(1965, 12, 21), Person.Sex.FEMALE, "elizabeth@second.ca");
        Person person5 = new Person("Charles", new LocalDate(1978, 10, 28), Person.Sex.MALE, "charles@prince.ca");
        Person person6 = new Person("Kate", new LocalDate(1995, 7, 14), Person.Sex.FEMALE, "kate@dutches.ca");

        List<Person> persons = new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);

//        printPersonsOlderThan(persons,20);

//        printPersonsWithinAgeRange(persons,10,25);

        printPersons(persons,new CheckPersonEligibleForSelectiveService());
        System.out.println("=====================================================");
        printPersons(persons,new CheckPerson(){
            @Override
            public boolean test(Person person) {
                return person.getGender() == Person.Sex.FEMALE &&
                        person.getAge() >= 10 &&
                        person.getAge() <= 25;
            }
        });
        System.out.println("=============LAMBDA==================================");
        printPersons(
                persons,
                (Person p)->p.getGender() == Person.Sex.FEMALE &&
                        p.getAge() >= 18
        );
    }

    public static void printPersons(List<Person> roster, CheckPerson checkPerson){
        for(Person person : roster){
            if(checkPerson.test(person)){
                System.out.println(person);
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high){
        for(Person person : roster){
            if(low <= person.getAge() && high >= person.getAge()){
                System.out.println(person);
            }
        }
    }

    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for(Person person : roster){
            if(person.getAge() >= age){
                System.out.println(person);
            }
        }
    }

}
