package com.everything.threads;

import java.util.Random;

/**
 * Created by mcalancea
 * Date: 05 Jun 2018
 * Time: 11:37
 */
public class RetrySleep {
    private int count = 1;
    private int next  = 0;
    private int retry = 1;
    private final int MAX_RETRIES = 5;
//    private final int FIRST_SLEEP = 1;//2 seconds

    public <R> R doWithRetry(SupplierWithException<R> supplier) throws Exception{
//        int i = 1;
//        for (; i <= MAX_RETRIES; ++i) {
//            int next = new Double(Math.pow(i, 2)).intValue();
//            System.out.println("next:" + next);
//        }
//        System.out.println("========================================");


        while(true){
            try {
                System.out.println("========================================");
                System.out.println("retry method: " + retry++);
                return supplier.get();
            }catch (Exception e){
                if(++count > MAX_RETRIES){
                    System.out.println(String.format("After max attempts (%s) it is still failing with exception", MAX_RETRIES));
                    throw e;
                } else {
                    next = new Double(Math.pow(count + 1, 2)).intValue();
                    System.out.println(String.format("Exception occurred (%s). Call retry count:%s and it will retry in %s seconds", e.getMessage(), count, next));
//                    Thread.sleep(TimeUnit.SECONDS.toMillis(next));
                    Thread.sleep(1L);
                }
            }
        }
    }

    public int getCount() {
        return count;
    }

    public int getNext() {
        return next;
    }

    public int getRetry() {
        return retry;
    }

    public static void main(String[] args){
        SupplierWithException<Integer> supplier = new SupplierWithException() {
            @Override
            public Integer get() throws Exception {
                int minRandom = 1;
                int maxRandom = 20;
                Random random = new Random();
                int randomNumber = random.nextInt(maxRandom + 1 - minRandom) + minRandom;
                System.out.println("randomNumber:" + randomNumber);
                if (randomNumber > 0) {
                    throw new IllegalArgumentException("test");
                }

                return randomNumber;
            }
        };

        RetrySleep retrySleep = new RetrySleep();
        int outOfRetry = 0;
        try{
            outOfRetry = retrySleep.doWithRetry(supplier);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("outOfRetry:" + outOfRetry);
        System.out.println("count:" + retrySleep.getCount());
        System.out.println("next:" + retrySleep.getNext());
        System.out.println("retry:" + retrySleep.getRetry());
    }
}
