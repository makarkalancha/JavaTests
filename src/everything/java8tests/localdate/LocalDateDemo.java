package everything.java8tests.localdate;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

/**
 * Created by mcalancea on 2016-04-19.
 */
public class LocalDateDemo {

    public static void main(String[] args) {
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//        System.out.println(localDate.toString());

//        LocalDateDemo.testZones();
//        LocalDateDemo.testZones1();
//        LocalDateDemo.testDateRange();

        LocalDate firstDayOfMonthDate = LocalDate.of(2011, Month.JANUARY, 1);
//        firstDayOfMonthDate.getMonth().getDisplayName(TextStyle.FULL, )
//        String month1 = firstDayOfMonthDate.format(DateTimeFormatter.loofPattern("MMMM, yyyy", new Locale("ru")));
//        System.out.println(month1);

        String month2 = firstDayOfMonthDate.format(DateTimeFormatter.ofPattern("MMMM", new Locale("ru")));
        System.out.println(month2);
    }

    public static void testDateRange(){
        LocalDate today = LocalDate.now();

        LocalDate start = today.withDayOfMonth(1);
        LocalDate end = today.withDayOfMonth(today.lengthOfMonth());

        DateRange cycle = new DateRange(start, end);

        String startDate = "2011-1-01";
        String endDate = "2017-04-01";
        if(!StringUtils.isEmpty(startDate) && !StringUtils.isEmpty(endDate)) {
            // Both fields should be standard iso days without time.
            start = LocalDate.parse(startDate, DateTimeFormatter.ISO_DATE);
            end = LocalDate.parse(endDate, DateTimeFormatter.ISO_DATE);

            if (start.isBefore(end)) {
                cycle = new DateRange(start, end);
            }
        }
        System.out.println();
    }

    public static void testZones(){
        TimeZone timeZone = TimeZone.getTimeZone("Australia/Sydney");
        ZoneId australia = ZoneId.of("Australia/Sydney");
//        ZoneId australia = ZoneId.of("Australia/South");
//        ZonedDateTime zonedDateTime= LocalDateTime.now().atZone(australia);
//        ZonedDateTime zonedDateTime = ZonedDateTime.now().withZoneSameInstant(australia);
        ZonedDateTime zonedDateTime = ZonedDateTime.now().withZoneSameInstant(timeZone.toZoneId());
        System.out.println(zonedDateTime);
//        Date date = Date.from(zonedDateTime.toLocalDate().atStartOfDay(timeZone.toZoneId()).toInstant());
        Date date = java.sql.Date.valueOf(zonedDateTime.toLocalDate());
        System.out.println(date);
    }

    public static void testZones1(){
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        LocalDateTime dt = LocalDateTime.now();

// Create a List using the set of zones and sort it.
        List<String> zoneList = new ArrayList<String>(allZones);
        Collections.sort(zoneList);

        for (String s : zoneList) {
            ZoneId zone = ZoneId.of(s);
            ZonedDateTime zdt = dt.atZone(zone);
            ZoneOffset offset = zdt.getOffset();
            int secondsOfHour = offset.getTotalSeconds() % (60 * 60);
            String out = String.format("%35s\t%10s%n", zone, offset);

            // Write only time zones that do not have a whole hour offset
            // to standard out.
//            if (secondsOfHour != 0) {
                System.out.printf(out);
//            }
        }
    }

    private static class DateRange {
        private final LocalDate start;
        private final LocalDate end;

        public DateRange(LocalDate start, LocalDate end) {
            this.start = start;
            this.end = end;
        }

        public LocalDate getStart() {
            return start;
        }

        public LocalDate getEnd() {
            return end;
        }
    }
}
