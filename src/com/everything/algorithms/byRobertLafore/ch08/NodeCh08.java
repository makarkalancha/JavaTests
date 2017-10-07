package com.everything.algorithms.byRobertLafore.ch08;

/**
 * User: Makar Kalancha
 * Date: 06/01/2015
 * Time: 14:51
 */
public class NodeCh08<T> {
    public T iData;
    public NodeCh08 leftChild;
    public NodeCh08 rightChild;

    public NodeCh08(T data) {
        iData = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "iData=" + iData +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}


