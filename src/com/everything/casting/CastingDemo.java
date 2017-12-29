package com.everything.casting;

/**
 * User: Makar Kalancha
 * Date: 29/12/2017
 * Time: 12:20
 */
public class CastingDemo {
    public static void main(String[] args) {
        Class<Integer> clazz = Integer.class;
        System.out.println(clazz.isInstance(Integer.class));
        System.out.println(clazz.isAssignableFrom(Integer.class));
        System.out.println(clazz.getCanonicalName());
    }
}
