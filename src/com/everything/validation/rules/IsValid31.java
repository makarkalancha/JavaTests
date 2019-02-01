package com.everything.validation.rules;

import com.everything.validation.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makar Kalancha
 * Date: 14 Sep 2017
 * Time: 17:08
 */
public class IsValid31 implements Rule {
    private final Integer dayOfMonthNumber;

    public IsValid31(Integer dayOfMonthNumber) {
        this.dayOfMonthNumber = dayOfMonthNumber;
    }

    @Override
    public List<String> validate() {
        List<String> result = new ArrayList<>();
        if(dayOfMonthNumber != 1) {
            result.add("not JANUARY");
        }
        return result;

    }
}
