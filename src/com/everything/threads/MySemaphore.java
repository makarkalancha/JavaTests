package com.everything.threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * User: Makar Kalancha
 * Date: 06/11/13
 * Time: 9:30 AM
 */
public class MySemaphore {
    public static void main (String [] main){
//        Semaphore semaphore = new Semaphore(2);// works
//        Semaphore semaphore = new Semaphore(0);// hangs
        Semaphore semaphore = new Semaphore(-2);// hangs

        new Person(semaphore, "John");
        new Person(semaphore, "Jessica");
        new Person(semaphore, "Jack");
        new Person(semaphore, "Jim");
    }
}

class Person extends Thread{
    Semaphore sem;
    Person(Semaphore s, String name){
        this.sem = s;
        setName(name);
        start();
    }

    @Override
    public void run() {
        try{
            System.out.println(getName()+": waiting");
            sem.acquire();
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            System.out.println(getName()+": working");
            sem.release();
            System.out.println(getName()+": finished");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(getName()+": gogogogo");
    }
}
