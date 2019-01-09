package com.everything.java8tests.localdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcalancea
 * Date: 18 Dec 2018
 * Time: 15:10
 */
public class DateTimeRangeTest {
    public static void main(String[] args) {
        testNonOverlappingDateRanges();
    }

    public static void testNonOverlappingDateRanges(){
        LocalDateTime date1 = LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 20), LocalTime.of(10,30));
        LocalDateTime date2 = LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 30), LocalTime.of(20,31));
        LocalDateTime date3 = LocalDateTime.of(LocalDate.of(2018, Month.NOVEMBER, 30), LocalTime.of(21,43));

        List<LocalDateTime> dates = new ArrayList<>();
        dates.add(date1);
        dates.add(date2);
        dates.add(date3);

        List<DateRange> dateRangeList = new ArrayList<>();
        for (int i = 0; i < dates.size(); i++) {
            LocalDate end = null;

            if(i < dates.size() - 1){
                end = dates.get(i + 1).toLocalDate().minusDays(1L);
            }

            LocalDate start = dates.get(i).toLocalDate();

//            if(end == null || start.compareTo(end) < 0) {
//                dateRangeList.add(new DateRange(start, end));
//            }

            if((end != null && start.compareTo(end) < 0) || end == null) {
                dateRangeList.add(new DateRange(start, end));
            }
        }
        System.out.println(dateRangeList);
    }
}


