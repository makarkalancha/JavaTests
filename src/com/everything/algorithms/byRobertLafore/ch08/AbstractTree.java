package com.everything.algorithms.byRobertLafore.ch08;

/**
 * User: Makar Kalancha
 * Date: 06/01/2015
 * Time: 14:57
 */
public abstract class AbstractTree<T extends Comparable> implements TreeInterface<T>{
    protected NodeCh08<T> _root;

    public AbstractTree(NodeCh08<T> root) {
        _root = root;
    }

    public void displayTree(){
        System.out.println(_root);
    }


}
