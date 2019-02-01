package com.everything.javafx.table_to_excel.decorator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * User: Makar Kalancha
 * Date: 22/10/2017
 * Time: 09:28
 */
public interface PersonDecorator {
    Long getId();
    String getRootName();
    String getDepartmentName();
    String getFirstName();
    Integer getAge();
    BigDecimal getSalary();
    LocalDateTime getStartDate();
}
