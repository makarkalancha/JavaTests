package com.everything;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 19/11/13
 * Time: 4:30 PM
 */
public class Inheritance {
    void doSmth(inhB b){
        System.out.println(b.b);
    }

    void doSmth(inhC c){
        System.out.println(c.c);
    }

    public static void main(String [] args){
        Inheritance i = new Inheritance();
        i.doSmth(new inhB());
        i.doSmth(new inhC());

        Set<String> s = new HashSet<String>();
        s.add("a");
        Set<String> b = new HashSet<String>();
        b.add("a");
        System.out.println("disjoint:"+Collections.disjoint(s,b));
    }
}

class inhA{
    int a = 10;

}

class inhB extends inhA{
    int b = 100;
}

class inhC extends inhA{
    int c = 1000;
}

