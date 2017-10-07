package com.everything.java8tests.lambda;


import com.google.common.base.Objects;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * User: Makar Kalancha
 * Date: 02/09/14
 * Time: 10:17 AM
 */
public class Person {
    public enum Sex{
        MALE,FEMALE
    }

    public Person(String name, LocalDate birthday, Sex gender, String emailAddress){
        this._name = name;
        this._birthday = birthday;
        this._gender = gender;
        this._emailAddress = emailAddress;
    }

    private String _name;
    private LocalDate _birthday;
    private Sex _gender;
    private String _emailAddress;

    public String getName() {
        return _name;
    }

    public LocalDate getBirthday() {
        return _birthday;
    }

    public Sex getGender() {
        return _gender;
    }

    public String getEmailAddress() {
        return _emailAddress;
    }

    public long getAge() {
        LocalDate now = LocalDate.now();
        return ChronoUnit.YEARS.between(_birthday, now);
    }

    @Override
    public String toString() {
        return "Person{" +
                "_name='" + _name + '\'' +
                ", _birthday=" + _birthday +
                ", _age=" + getAge() +
                ", _gender=" + _gender +
                ", _emailAddress='" + _emailAddress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Person) {
            Person that = (Person) other;
            return Objects.equal(getName(), that.getName())
                    && Objects.equal(getBirthday(), that.getBirthday())
                    && Objects.equal(getAge(), that.getAge())
                    && Objects.equal(getGender(), that.getGender())
                    && Objects.equal(getEmailAddress(), that.getEmailAddress())
                    ;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName(), getBirthday(), getAge(), getGender(), getEmailAddress());
    }
}
