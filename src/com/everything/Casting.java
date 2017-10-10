package com.everything;

/**
 * User: Makar Kalancha
 * Date: 14/11/13
 * Time: 11:06 AM
 */
public class Casting {

    public static void main(String[] args){
//        A a1 = new A();
//        a1.doSmth();
//        A ab1 = new B();
//        ab1.doSmth();
//
////        com.everything.B b1 = (com.everything.B) a1;
//        B b1 = (B) ab1;
//        b1.doSmth();

        A a2 = new A();
        if(a2 instanceof A){
            System.out.println("hello");
            if(a2.getString().equals("string")){
                System.out.println("strings are equal");
            } else{
                System.out.println("strings are not equal");
            }
        }
    }
}

class A{
    int a = 10;
    public void doSmth(){
        System.out.println("a");
    }

    public String getString() {
//        return "string";
        return null;
    }
}

class B extends A{
    int b= 20;
    public void doSmth(){
        System.out.println("b");
    }
}
