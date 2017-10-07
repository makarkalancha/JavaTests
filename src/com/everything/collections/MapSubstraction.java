package com.everything.collections;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * User: Makar Kalancha
 * Date: 06/06/14
 * Time: 11:27 AM
 */
public class MapSubstraction {
    public static void main(String[] args) {
        InnerClass first = new InnerClass(1);
        InnerClass second = new InnerClass(2);
        InnerClass third = new InnerClass(3);
        InnerClass fourth = new InnerClass(4);
        InnerClass fifth = new InnerClass(5);

        Map<Integer, InnerClass> mapA = new TreeMap<>();
        mapA.put(1, first);
        mapA.put(2, second);
        mapA.put(3, third);
        mapA.put(4, fourth);
        mapA.put(5, fifth);

        InnerClass sixth = new InnerClass(6);
        Map<Integer, InnerClass> mapB = new TreeMap<>();
        mapB.put(2, second);
        mapB.put(3, third);
        mapB.put(5, fifth);
        mapB.put(6, sixth);

        System.out.println("a:"+ Arrays.toString(mapA.keySet().toArray()));
        System.out.println("b:"+Arrays.toString(mapB.keySet().toArray()));

        Map<Integer, InnerClass> union = new TreeMap<>(mapA);
        union.putAll(mapB);
        System.out.println("union:"+Arrays.toString(union.keySet().toArray()));
        Set<Integer> diff = new TreeSet<>(union.keySet());
        diff.removeAll(mapB.keySet());
        System.out.println("diff:"+Arrays.toString(diff.toArray()));

        System.out.println("\n--purge");
        for(int i : diff) {
            InnerClass innerClass = union.get(i);
            innerClass.deleted = true;
        }

        System.out.println("\niteration:\n");
        for(Map.Entry<Integer, InnerClass> entry : union.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
    private static class InnerClass{
        public int _int;
        public boolean deleted = false;
        public InnerClass(int i) {
            this._int = i;
        }

        @Override
        public String toString() {
            return "_int:"+_int+"; deleted:"+deleted;
        }
    }
}

