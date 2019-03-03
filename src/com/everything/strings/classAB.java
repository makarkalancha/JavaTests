package com.everything.strings;

/**
 * User: Makar Kalancha
 * Date: 02/09/14
 * Time: 9:39 AM
 */
public class classAB {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        System.out.println(classA.firstA == classB.firstB);
        System.out.println(classA.firstA == classB.firstNewB);
    }
}
