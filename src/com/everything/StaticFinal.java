package com.everything;

/**
 * User: Makar Kalancha
 * Date: 29/10/13
 * Time: 9:32 AM
 */
public class StaticFinal extends Base{
    public static void doSmth(){
        System.out.println("hello_derived");
    }

    public static void doAnyth1(){
        System.out.println("bye_derived");
    }

    public static void main(String[] args){
        StaticFinal.doAnyth();
        StaticFinal.doSmth();
        Base.doSmth();
        Base.doAnyth();
    }
}

class Base{
    protected static void doSmth(){
        System.out.println("hello");
    }

    protected static final void doAnyth(){
        System.out.println("bye");
    }
}