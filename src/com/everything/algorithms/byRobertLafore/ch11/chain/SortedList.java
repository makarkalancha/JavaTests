package com.everything.algorithms.byRobertLafore.ch11.chain;

/**
 * User: Makar Kalancha
 * Date: 23/01/2015
 * Time: 16:12
 */
public class SortedList <T extends Comparable>{
    private Link<T> first;
    public SortedList(){
        first = null;
    }

    public void insert(Link<T> theLink) {
        T key = theLink.getKey();
        Link<T> previous = null;
        Link<T> current = first;

        while(current != null && key.compareTo(current.getKey()) == 1){
            previous = current;
            current = current.next;
        }

        if(previous == null) {
            first = theLink;
        } else {
            previous.next = theLink;
        }

        theLink.next = current;
    }

    public void delete(T key){
        Link<T> previous = null;
        Link<T> current = first;

        while(current != null && key.compareTo(current.getKey()) != 0){
            previous = current;
            current = current.next;
        }

        if(previous == null) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    public Link<T> find(T key) {
        Link<T> current = first;

        while(current != null && (current.getKey().compareTo(key) == 0 || current.getKey().compareTo(key) == -1)){
            if(current.getKey().compareTo(key) == 0) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void displayList(){
        System.out.print("List (first-->last): ");
        Link<T> current = first;
        while(current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}
