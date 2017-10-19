package com.everything.javafx.table_to_excel;

import com.google.common.base.Objects;

/**
 * Created by Makar Kalancha
 * Date: 19 Oct 2017
 * Time: 11:52
 */
public class Person {
    private final String firstName;
    private final String lastName;
    private final String email;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Person) {
            Person that = (Person) other;
            return Objects.equal(getFirstName(), that.getFirstName())
                    && Objects.equal(getLastName(), that.getLastName())
                    && Objects.equal(getEmail(), that.getEmail())
                    ;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFirstName(), getLastName(), getEmail());
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
