package com.everything.threads;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mcalancea
 * Date: 05 Jun 2018
 * Time: 11:37
 */
public class RetrySleep {
    private int count = -1;
    private final int MAX_RETRIES = 5;
    private final int FIRST_SLEEP = 2;//2 seconds

    public <R> R doWithRetry(SupplierWithException<R> supplier) throws Exception{
        for (int i = 0; i < MAX_RETRIES; i++) {
            int next = new Double(Math.pow(FIRST_SLEEP + i, 2)).intValue();
            System.out.println("next:" + next);
        }
        System.out.println("========================================");
        while(true){
            try {
                return supplier.get();

            }catch (Exception e){
                if(++count == MAX_RETRIES){
                    throw e;
                } else {
                    int next = new Double(Math.pow(FIRST_SLEEP + count, 2)).intValue();
                    System.out.println(String.format("Exception occurred (%s). Call retry count:%s and it will retry in %s seconds", e.getMessage(), count, next));
                    Thread.sleep(TimeUnit.SECONDS.toMillis(next));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        SupplierWithException<Integer> supplier = new SupplierWithException() {
            @Override
            public Integer get() throws Exception {
                int minRandom = 1;
                int maxRandom = 20;
                Random random = new Random();
                int randomNumber = random.nextInt(maxRandom + 1 - minRandom) + minRandom;
                System.out.println("randomNumber:" + randomNumber);
                if (randomNumber > 10) {
                    throw new IllegalArgumentException("test");
                }

                return randomNumber;
            }
        };

        RetrySleep retrySleep = new RetrySleep();
        int outOfRetry = retrySleep.doWithRetry(supplier);
        System.out.println("outOfRetry:" + outOfRetry);
    }
}
