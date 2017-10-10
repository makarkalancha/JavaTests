package com.everything.algorithms.byRobertLafore.ch04.collection;

/**
 * User: Makar Kalancha
 * Date: 11/04/2016
 * Time: 23:44
 */
public interface Stack<T> {
    void push(T t);// 	addFirst(e)
    T pop();// 	removeFirst()
    boolean isEmpty();
    void clear();
    T peek();// 	peekFirst()
    int size();
}
