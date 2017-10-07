package com.everything.java8tests.functionalprogramming.ch07.factorial;

import java.util.stream.Stream;

/**
 * Created by mcalancea on 2015-10-09.
 */
public interface TailCall<T> {
    TailCall<T> apply();

    default boolean isCompleted(){
        return false;
    }

    default T result() {
        throw new Error("not implemented");
    }

    default T invoke(){
        return Stream.iterate(this, TailCall::apply)
                .filter(TailCall::isCompleted)
                .findFirst()
                .get()
                .result();
    }
}
