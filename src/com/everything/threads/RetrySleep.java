package com.everything.threads;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by mcalancea
 * Date: 05 Jun 2018
 * Time: 11:37
 */
public class RetrySleep {
    public static void main(String[] args) throws Exception{
        int count = -1;
        int maxRetries = 5;
        int firstSleep = 2;//2 seconds

        int minRandom = 1;
        int maxRandom = 20;
        Random random = new Random();

        for (int i = 0; i < maxRetries; i++) {
            int next = new Double(Math.pow(firstSleep + i, 2)).intValue();
            System.out.println("next:" + next);
        }
        System.out.println("========================================");
        while(true){
            try {
                int randomNumber = random.nextInt(maxRandom + 1 - minRandom) + minRandom;
                System.out.println(String.format("count:%s; randomNumber:%s", count, randomNumber));
                if (randomNumber > 10) {
                    throw new IllegalArgumentException("test");
                }
                break;
            }catch (Exception e){
                if(++count == maxRetries){
                    throw e;
                } else {
                    int next = new Double(Math.pow(firstSleep + count, 2)).intValue();
                    System.out.println(String.format("count:%s; next:%s", count, next));
                    Thread.sleep(TimeUnit.SECONDS.toMillis(next));
                }
            }
        }
    }
}
