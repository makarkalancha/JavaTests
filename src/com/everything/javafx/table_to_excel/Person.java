package com.everything.javafx.table_to_excel;

import com.google.common.base.Objects;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Makar Kalancha
 * Date: 19 Oct 2017
 * Time: 11:52
 */
public class Person {
    private final String firstName;
    private final int age;
    private final BigDecimal salary;
    private final LocalDateTime startDate;

    public Person(String firstName, int age, BigDecimal salary, LocalDateTime startDate) {
        this.firstName = firstName;
        this.age = age;
        this.salary = salary;
        this.startDate = startDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Person) {
            Person that = (Person) other;
            return Objects.equal(getFirstName(), that.getFirstName())
                    && Objects.equal(getAge(), that.getAge())
                    && getSalary().compareTo(that.getSalary()) == 0
                    && Objects.equal(getStartDate(), that.getStartDate())
                    ;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFirstName(), getAge(), getSalary(), getStartDate());
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", startDate=" + startDate +
                '}';
    }
}
