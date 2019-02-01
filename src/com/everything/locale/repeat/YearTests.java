package com.everything.locale.repeat;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Makar Kalancha
 * Date: 10/12/2017
 * Time: 10:32
 */
public class YearTests {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2017, Month.DECEMBER, 12);
        int maxOccurrence = 7;
        LocalDate end = LocalDate.of(2022, Month.JUNE, 21);
        int repeatEvery = 2;

        /////////////////////method
        List<LocalDate> result = new ArrayList<>();


        LocalDate currentDate = start;
        //by occurrence
//        while(result.size() < maxOccurrence) {
//            result.add(currentDate);
//            currentDate = currentDate.plus(repeatEvery, ChronoUnit.YEARS);
//        }

        //by enddate
        while(!currentDate.isAfter(end)) {
            result.add(currentDate);
            currentDate = currentDate.plus(repeatEvery, ChronoUnit.YEARS);
        }

        System.out.println(result);
    }
}
