package com.everything.threads;

import java.util.concurrent.Callable;

/**
 * Created by mcalancea on 2015-08-19.
 */
public class CallableTest {

    public static void main(String[] args) {
        Callable<Boolean> testCallable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                System.out.println("in call...");
                Thread.currentThread().sleep(2000);
                System.out.println("end");
                return true;
            }
        };
        try {
            boolean result = testCallable.call();
            System.out.println("result is:" + result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}
