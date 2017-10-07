package com.everything.algorithms;

/**
 * User: Makar Kalancha
 * Date: 22/08/14
 * Time: 4:42 PM
 */
public class HolderT<T> {
    private T first;
    private T second;
    public HolderT(T one, T two){
        this.first = one;
        this.second = two;
//        swap();
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

//    private void swap() {
//        first += second;
//        second = first - second;
//        first -= second;
//    }
}
