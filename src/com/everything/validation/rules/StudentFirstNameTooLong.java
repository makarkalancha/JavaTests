package com.everything.validation.rules;

import com.everything.validation.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makar Kalancha
 * Date: 14 Sep 2017
 * Time: 16:21
 */
public class StudentFirstNameTooLong implements Rule {
    private final String firstName;

    public StudentFirstNameTooLong(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public List<String> validate() {
        List<String> result = new ArrayList<>();
        if(firstName.length() > 10) {
            result.add(String.format("first name (%s) is too long", firstName));
        }
        return result;
    }
}
