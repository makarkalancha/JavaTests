package com.everything.javafx.table_to_excel.decorator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * User: Makar Kalancha
 * Date: 22/10/2017
 * Time: 09:31
 */
public class PersonRootDecorator implements PersonDecorator {
    private final String rootName;

    public PersonRootDecorator(String name) {
        this.rootName = name;
    }

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public String getRootName() {
        return rootName;
    }

    @Override
    public String getDepartmentName() {
        return null;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public Integer getAge() {
        return null;
    }

    @Override
    public BigDecimal getSalary() {
        return null;
    }

    @Override
    public LocalDateTime getStartDate() {
        return null;
    }
}
