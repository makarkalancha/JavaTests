package com.everything.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: Makar Kalancha
 * Date: 06/06/14
 * Time: 10:43 AM
 */
public class SetTests {
    public static void main(String[] args) {
//        Set<String> a = new TreeSet<>();
//        a.add("1");
//        a.add("2");
//        a.add("3");
//        a.add("4");
//        a.add("5");
//
//        Set<String> b = new TreeSet<>();
//        b.add("2");
//        b.add("3");
//        b.add("5");
//        b.add("6");
//
//        System.out.println("a:"+Arrays.toString(a.toArray()));
//        System.out.println("b:"+Arrays.toString(b.toArray()));
//
//        Set<String> union = new TreeSet<>(a);
//        union.addAll(b);
//        System.out.println("union:"+Arrays.toString(union.toArray()));
//
//        Set<String> intersection = new TreeSet<>(a);
//        intersection.retainAll(b);
//        System.out.println("intersection:"+Arrays.toString(intersection.toArray()));
//
//        Set<String> difference = new TreeSet<>(a);
//        difference.removeAll(b);
//        System.out.println("difference:"+Arrays.toString(difference.toArray()));
//
//
//        System.out.println("\nsymmetric difference");
//        Set<String> tmp = new TreeSet<>(a);
//        tmp.retainAll(b);
//        System.out.println("tmp:" + Arrays.toString(tmp.toArray()));
//        union.removeAll(tmp);
//        System.out.println("union:"+Arrays.toString(union.toArray()));
//
//        List<String> nullArrayList = null;
//        List<String> nullArrayList_1 = new ArrayList<>(nullArrayList);

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("two");
        linkedHashSet.add("one");
        linkedHashSet.add("one");
        linkedHashSet.add("three");
        System.out.println(linkedHashSet);

        linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addAll(Arrays.asList("two", "one", "one", "three"));
        System.out.println(linkedHashSet);

        linkedHashSet = new HashSet<>();
        linkedHashSet.addAll(Arrays.asList("two", "one", "one", "three"));
        System.out.println(linkedHashSet);
    }

}
