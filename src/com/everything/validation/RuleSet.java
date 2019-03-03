package com.everything.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Makar Kalancha
 * Date: 14 Sep 2017
 * Time: 16:18
 */
public interface RuleSet<T> {
    List<Rule> getRules();

    default List<String> validate(){
        List<String> errors = new ArrayList<>();
        for(Rule rule : getRules()){
            errors.addAll(rule.validate());
        }
        return errors;
    }
}
