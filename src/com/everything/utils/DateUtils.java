package com.everything.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: Makar Kalancha
 * Date: 12/12/13
 * Time: 4:20 PM
 */
public class DateUtils {
    public static void main(String[] args) {
//        Timestamp ts = new Timestamp(System.currentTimeMillis()+10000000000L);
//        String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(ts.getTime())).toString();
//        System.out.println(str);
//        String dateSt = "2014-04-11 1:30 PM";
        String dateSt = "2014-01-15 3:00 pm";
//        String dateSt = "2014-february-20 11:30 am";

        try{
////            System.out.println(new SimpleDateFormat("MM/dd/yyyy hh:mm a").parse(dateSt).toString());
            System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm a").parse(dateSt).toString());
//            System.out.println(new SimpleDateFormat("yyyy-MMMM-dd hh:mm a").parse(dateSt).toString());
//
////            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
////            String dateSt1 = "2014-05-22 17:14:22.712";
////            String dateSt2 = "2014-05-22 17:14:27.863";
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
//            String dateSt1 = "09:46:50.391";
//            String dateSt2 = "11:24:32.788";
//
//            Date date1 = sdf.parse(dateSt1);
//            Date date2 = sdf.parse(dateSt2);
//            System.out.println("date1 millis:"+date1+" / "+date1.getTime());
//            System.out.println("date2 millis:"+date2+" / "+date2.getTime());
//
//            System.out.println(elapsedTimeToDateFormat(date1, date2));
//            SimpleDateFormat sdfElapsed = new SimpleDateFormat("dd 'days' HH:mm:ss.SSS");


//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd't'HH:mm:ssz");
////            String dateSt1 = "Fri, 08 Aug 2014 18:00:18 +0000";
//            String dateSt1 = "2014-11-03t00:00:00-0500";
//
//            Date date1 = sdf.parse(dateSt1);
//            System.out.println("date1 millis:\n"+date1+"\n"+date1.getTime());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dateEndString = "2014-01-15";
//            String dateEndString = null;

            Calendar dateEnd = Calendar.getInstance();
            dateEnd.setTime(sdf.parse(dateEndString));

            Calendar dateCurrent = Calendar.getInstance();

            System.out.println("end date:" + sdf.format(dateEnd.getTime()));
            System.out.println("current date:" + sdf.format(dateCurrent.getTime()));
            System.out.println("is end date > current date: " + (dateEnd.compareTo(dateCurrent)));

//        System.out.println(str);
//        String dateSt = "2014-04-11 1:30 PM";

        }catch (ParseException e){
            e.printStackTrace();
        }

//        System.out.println(duration(135007L));
    }

    public static String duration(long millis) {
//        return String.format("%d:%d",
//                TimeUnit.MILLISECONDS.toMinutes(millis),
//                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))
        long minuteQty = TimeUnit.MILLISECONDS.toMinutes(millis);
        String minuteSt = covert2DigitNumberIntoString(minuteQty);
        long secondsQty = TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(minuteQty);
        String secondSt = covert2DigitNumberIntoString(secondsQty);
        long millisQty = millis - TimeUnit.MINUTES.toMillis(minuteQty) - TimeUnit.SECONDS.toMillis(secondsQty);
        String milliSt = covert3DigitNumberIntoString(millisQty);
        return String.format("%1$s:%2$s.%3$s",
                minuteSt,
                secondSt,
                milliSt
        );
    }

    private static String covert2DigitNumberIntoString(long number) {
        return (number < 10) ? "0" + number : Long.toString(number);
    }

    private static String covert3DigitNumberIntoString(long number) {
        return (number < 10) ? "00" + number : (number < 100) ? "0" + number : Long.toString(number);
    }

    private static long getLongMax(long a, long b) {
        return (a > b ) ? a : b;
    }

    private static long getLongMin(long a, long b) {
        return (a < b ) ? a : b;
    }

    public static String elapsedTimeToDateFormat(Date date1 ,Date date2) {
        long date1Long = date1.getTime();
        long date2Long = date2.getTime();
        long elapsedTimeInMillis = getLongMax(date1Long, date2Long) - getLongMin(date1Long, date2Long);
        StringBuilder builder = new StringBuilder();
        long days = TimeUnit.MILLISECONDS.toDays(elapsedTimeInMillis);
        if (days > 0) {
            elapsedTimeInMillis = elapsedTimeInMillis % TimeUnit.DAYS.toMillis(days);
        }
        long hours = TimeUnit.MILLISECONDS.toHours(elapsedTimeInMillis);
        if (hours > 0) {
            elapsedTimeInMillis = elapsedTimeInMillis % TimeUnit.HOURS.toMillis(hours);
        }
        long minutes = TimeUnit.MILLISECONDS.toMinutes(elapsedTimeInMillis);
        if (minutes > 0) {
            elapsedTimeInMillis = elapsedTimeInMillis % TimeUnit.MINUTES.toMillis(minutes);
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTimeInMillis);
        if (seconds > 0) {
            elapsedTimeInMillis = elapsedTimeInMillis % TimeUnit.SECONDS.toMillis(seconds);
        }
        long millis = TimeUnit.MILLISECONDS.toMillis(elapsedTimeInMillis);

        builder.append(days + ((days == 1) ? " day " : " days ")).
                append(((hours < 10) ? "0" + hours : hours)).
                append(":").
                append(((minutes < 10) ? "0" + minutes : minutes)).
                append(":").
                append(((seconds < 10) ? "0" + seconds : seconds)).
                append(".").
                append(((millis < 10) ? "00" + millis : (millis < 100) ? "0" + millis : millis));

        return builder.toString();
    }
}
