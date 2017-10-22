package com.everything.javafx.table_to_excel.decorator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * User: Makar Kalancha
 * Date: 22/10/2017
 * Time: 09:31
 */
public class PersonDepartmentDecorator implements PersonDecorator {
    private final Long departmentNumber;
    private final String departmentName;

    public PersonDepartmentDecorator(Long departmentNumber, String departmentName) {
        this.departmentNumber = departmentNumber;
        this.departmentName = departmentName;
    }

    @Override
    public Long getId() {
        return departmentNumber;
    }

    @Override
    public String getRootName() {
        return null;
    }

    @Override
    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String getFirstName() {
        return null;
    }

    @Override
    public int getAge() {
        return 0;
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
