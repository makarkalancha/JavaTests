package com.everything.java8tests.localdate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by mcalancea
 * Date: 18 Apr 2018
 * Time: 11:22
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
//        String timeDate = "2018-04-21T16:45:03Z";
        String timeDate = "2011-12-03T10:15:30Z";
//        String timeDate = "2018-04-21T16:45:03";
//        String timeDate = "2011-12-03T10:15:30";
//        String timeDate = "2018-04-25T16:45:03.000Z";

        String patternISO_LOCAL_DATE_TIME = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}";
        String patternISO_DATE_TIME = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}Z";
        System.out.println(timeDate.matches(patternISO_LOCAL_DATE_TIME));

//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_INSTANT;
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

        LocalDateTime localDateTime = LocalDateTime.parse(timeDate, dateTimeFormatter);
//        LocalDateTime localDateTime = LocalDateTime.parse(timeDate);

        System.out.println(localDateTime);

//        String str = "1986-04-08 12:30";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
//        System.out.println(dateTime);
    }
}
