package com.everything.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Makar Kalancha
 * Date: 11 Oct 2017
 * Time: 16:59
 */
public class DateTest {
    public static void main(String[] args) {
//        int retryCount = 3;
//        int addition = (retryCount + 1)* (retryCount + 1);
//        System.out.println(addition);
//
//        Date date = new Date();
//        System.out.println(date);
//        long millis = date.getTime();
////        long minutes = TimeUnit.MILLISECONDS.toSeconds(millis);
//        long minutes = millis;
//
//
//        System.out.println(minutes);
////        Date newDate = new Date(TimeUnit.SECONDS.toMillis(minutes));
//        Date newDate = new Date(minutes);
//        System.out.println(newDate);
//
//        System.out.println("========================================");
//        addition = new Double(Math.pow(retryCount + 1, 2)).intValue();
//        LocalDateTime localDateTime = LocalDateTime.now();
//        LocalDateTime newLocalDateTime = localDateTime.plusMinutes(addition);
//        System.out.println(addition);
//        System.out.println(localDateTime);
//        System.out.println(newLocalDateTime);
//
//
//        System.out.println("timezone: " + TimeZone.getDefault());

        System.out.println(isValidDate("20-01-2014"));
        System.out.println(isValidDate("11-04-2015 22:01:33:023"));

        System.out.println(isValidDate("32476347656435"));
    }

    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:ms");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
