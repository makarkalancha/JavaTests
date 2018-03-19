package com.everything.date;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Makar Kalancha
 * Date: 11 Oct 2017
 * Time: 16:59
 */
public class DateTest {
    public static void main(String[] args) {
        int retryCount = 3;
        int addition = (retryCount + 1)* (retryCount + 1);
        System.out.println(addition);

        Date date = new Date();
        System.out.println(date);
        long millis = date.getTime();
//        long minutes = TimeUnit.MILLISECONDS.toSeconds(millis);
        long minutes = millis;


        System.out.println(minutes);
//        Date newDate = new Date(TimeUnit.SECONDS.toMillis(minutes));
        Date newDate = new Date(minutes);
        System.out.println(newDate);

        System.out.println("========================================");
        addition = new Double(Math.pow(retryCount + 1, 2)).intValue();
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime newLocalDateTime = localDateTime.plusMinutes(addition);
        System.out.println(addition);
        System.out.println(localDateTime);
        System.out.println(newLocalDateTime);


        System.out.println("timezone: " + TimeZone.getDefault());
    }
}
