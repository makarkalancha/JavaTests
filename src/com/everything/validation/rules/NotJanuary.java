package com.everything.validation.rules;

import com.everything.validation.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makar Kalancha
 * Date: 14 Sep 2017
 * Time: 16:26
 */
public class NotJanuary implements Rule {
    private final Integer monthNumber;

    public NotJanuary(Integer monthNumber) {
        this.monthNumber = monthNumber;
    }

    @Override
    public List<String> validate() {
        List<String> result = new ArrayList<>();
        if(monthNumber != 1) {
            result.add("not JANUARY");
        }
        return result;

    }
}
