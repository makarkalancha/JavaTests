package com.everything.java8tests.lambda;

/**
 * User: Makar Kalancha
 * Date: 02/09/14
 * Time: 11:36 AM
 */
public class CheckPersonEligibleForSelectiveService implements CheckPerson{
    @Override
    public boolean test(Person person) {
        return person.getGender() == Person.Sex.MALE &&
                person.getAge() >= 18 &&
                person.getAge() <= 35;
    }
}
