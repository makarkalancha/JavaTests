package com.everything.java8tests.functionalprogramming;

/**
 * User: Makar Kalancha
 * Date: 17/01/2016
 * Time: 23:06
 */
public class Person {
    private final String name;
    private final int age;
    public Person(final String theName, final int theAge) {
        name = theName;
        age = theAge;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int ageDifference(final Person other) {
        return age - other.age;
    }
    public String toString() {
        return String.format("%s - %d", name, age);
    }
}
