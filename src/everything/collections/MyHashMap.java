package com.test.everything.collections;

import java.util.*;

/**
 * User: Makar Kalancha
 * Date: 08/11/13
 * Time: 2:25 PM
 */
public class MyHashMap {
    public static void main(String [] args){
//        com.test.everything.collections.Person_hashmap a = new com.test.everything.collections.Person_hashmap("1","john");
//        com.test.everything.collections.Person_hashmap b = new com.test.everything.collections.SubPerson_hashmap("2","jack","any");
//        com.test.everything.collections.SubPerson_hashmap c = new com.test.everything.collections.SubPerson_hashmap("3","jess","bbb");
//        Map<String, com.test.everything.collections.Person_hashmap> map = new HashMap<String, com.test.everything.collections.Person_hashmap>();
//        map.put("1",a);
//        map.put("2",b);
//        map.put("3",c);
//
//        com.test.everything.collections.Person_hashmap a1 = map.get("1");
//        com.test.everything.collections.Person_hashmap b1 = map.get("2");
//        com.test.everything.collections.Person_hashmap c1 = map.get("3");
//        System.out.println(a1);
//        System.out.println(b1);
//        System.out.println(c1);


//        Map<String, String> map = new HashMap<String, String>();
//        map.put("a", "");
//        map.put("b", "");
//        map.put("c", "");
//
//        Set<String> set = new HashSet<String>();
//        set.add("a");
//        set.add("b");
//        System.out.println("map:"+ Arrays.toString(map.keySet().toArray()));
//        System.out.println("set:"+ Arrays.toString(set.toArray()));
//
//        map.keySet().removeAll(set);
//        System.out.println("map:"+ Arrays.toString(map.keySet().toArray()));

        Set<String> result = new HashSet<String>();
        result.add("a");
        result.add("b");
        result.add("c");
        Set<String> add = Collections.EMPTY_SET;
        result.addAll(add);
        System.out.println("set:"+ Arrays.toString(result.toArray()));
    }
}

class Person_hashmap{
    String id;
    String name;
    Person_hashmap(String i, String n){
        this.id = i;
        this.name = n;
    }

    @Override
    public String toString() {
        return "id: "+id+"; name: "+name;
    }
}

class SubPerson_hashmap extends Person_hashmap{
    String company;
    SubPerson_hashmap(String i, String n, String c){
        super(i,n);
        this.company = c;
    }
    @Override
    public String toString() {
        return super.toString()+"; company: "+company;
    }
}
