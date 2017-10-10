package com.everything.validation;


import com.everything.validation.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Makar Kalancha
 * Date: 14 Sep 2017
 * Time: 15:54
 */
public class ValidationDemo {
    public static void main(String[] args) {
        Student s1 = new Student("first1", "last1", 1, 3, 2000);
        Student s2 = new Student("first222222222", "last2", 1, 2, 2000);
        List<Student> list = Arrays.asList(s1,s2);

        StudentRuleSet studentRuleSet = null;
        List<String> errors = new ArrayList<>();
        for(Student student : list) {
            studentRuleSet = new StudentRuleSet(student);
            errors.addAll(studentRuleSet.validate());
        }
        System.out.println(errors);
    }
}
