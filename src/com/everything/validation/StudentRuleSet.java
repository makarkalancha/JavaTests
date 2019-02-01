package com.everything.validation;

import com.everything.validation.entity.Student;
import com.everything.validation.rules.NotJanuary;
import com.everything.validation.rules.StudentFirstNameTooLong;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Makar Kalancha
 * Date: 14 Sep 2017
 * Time: 16:22
 */
public class StudentRuleSet implements RuleSet<Student>{
    private final Student student;

    public StudentRuleSet(Student student) {
        this.student = student;
    }

    @Override
    public List<Rule> getRules() {
        LinkedList<Rule> rules = new LinkedList<>();
        rules.add(new StudentFirstNameTooLong(student.getFirstName()));
        rules.add(new NotJanuary(student.getMonthOfBirth()));

        return new LinkedList<>(rules);
    }
}
