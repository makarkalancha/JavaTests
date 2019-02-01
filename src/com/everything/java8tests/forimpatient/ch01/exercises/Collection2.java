package com.everything.java8tests.forimpatient.ch01.exercises;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * User: Makar Kalancha
 * Date: 02/02/2015
 * Time: 13:39
 */
public interface Collection2<T> extends Collection<T>{
    default void forEachIf(Consumer<T> action, Predicate<T> filter){
        forEach(
                e-> {
                    if (filter.test(e)) {
                        action.accept(e);
                    }
                }
        );
    };
}
