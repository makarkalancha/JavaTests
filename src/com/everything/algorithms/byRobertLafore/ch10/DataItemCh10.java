package com.everything.algorithms.byRobertLafore.ch10;

/**
 * User: Makar Kalancha
 * Date: 15/01/2015
 * Time: 12:45
 */
public class DataItemCh10<T extends Comparable> {
    public T dData;

    public DataItemCh10(T dd){
        this.dData = dd;
    }

    @Override
    public String toString() {
        return "/" + dData ;
    }
}
