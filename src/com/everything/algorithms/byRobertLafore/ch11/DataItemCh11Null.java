package com.everything.algorithms.byRobertLafore.ch11;

/**
 * User: Makar Kalancha
 * Date: 20/01/2015
 * Time: 17:28
 */
public class DataItemCh11Null<T extends Comparable> extends DataItemCh11 {

    public DataItemCh11Null() {
    }

    @Override
    public T getKey() {
        return null;
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
