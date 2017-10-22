package com.everything.javafx.table_to_excel.decorator;

import com.everything.javafx.table_to_excel.pojo.Person;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * User: Makar Kalancha
 * Date: 22/10/2017
 * Time: 09:31
 */
public class PersonObjDecorator implements PersonDecorator {
    private final Person person;

    public PersonObjDecorator(Person person) {
        this.person = person;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getRootName() {
        return null;
    }

    @Override
    public String getDepartmentName() {
        return null;
    }

    @Override
    public String getFirstName() {
        return person.getFirstName();
    }

    @Override
    public int getAge() {
        return person.getAge();
    }

    @Override
    public BigDecimal getSalary() {
        return person.getSalary();
    }

    @Override
    public LocalDateTime getStartDate() {
        return person.getStartDate();
    }
}
