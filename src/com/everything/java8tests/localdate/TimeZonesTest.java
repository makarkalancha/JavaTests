package com.everything.java8tests.localdate;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by mcalancea
 * Date: 04 May 2018
 * Time: 11:30
 */
public class TimeZonesTest {
    public static void main(String[] args) throws Exception {
//        Set<String> allZones = ZoneId.getAvailableZoneIds();
//        LocalDateTime localDateTime = LocalDateTime.now();
//
//        List<String> allZoneList = new ArrayList<>(allZones);
//        Collections.sort(allZoneList);
//
//        for(String s : allZoneList){
//            ZoneId zoneId = ZoneId.of(s);
//            ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
//            ZoneOffset zoneOffset = zonedDateTime.getOffset();
////            int secondsOfHour = zoneOffset.getTotalSeconds()
//            String offset = String.format("%35s %10s%n", zoneId, zoneOffset);
//
//            System.out.print(offset);
//        }

//        OffsetDateTime local = OffsetDateTime.ofInstant(Instant.ofEpochMilli(new Timestamp(1525217705000L).getTime()), ZoneId.of("GMT-04:00")); //callTime
//        System.out.println(local);
//        OffsetDateTime utc = OffsetDateTime.ofInstant(Instant.ofEpochMilli(new Timestamp(1525217705000L).getTime()), ZoneId.of("GMT")); //callTime
//        System.out.println(utc);
//        System.out.println("================================");
//        OffsetDateTime local1 = OffsetDateTime.ofInstant(Instant.ofEpochMilli(new Timestamp(1525221305000L).getTime()), ZoneId.of("GMT-04:00")); //callTime
//        System.out.println(local1);
//        OffsetDateTime utc1 = OffsetDateTime.ofInstant(Instant.ofEpochMilli(new Timestamp(1525221305000L).getTime()), ZoneId.of("GMT")); //callTime
//        System.out.println(utc1);

//        LocalDateTime localDate = LocalDateTime.parse("2018-05-01T10:08:16-04:00", DateTimeFormatter.ISO_DATE_TIME);// ("yyyy-MM-dd'T'HH:mm:ssX"))
//        System.out.println(localDate);
//        long epochMilli1 = localDate.toInstant(ZoneOffset.UTC).toEpochMilli();
//        long epochMilli2 = localDate.toInstant(ZoneOffset.UTC).toEpochMilli();
//        System.out.println(epochMilli1);
//        System.out.println(epochMilli2);

        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2018-05-01T10:08:16-04:00", DateTimeFormatter.ISO_DATE_TIME);// ("yyyy-MM-dd'T'HH:mm:ssX"))
//        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2018-05-01T10:08:16-04:00");// ("yyyy-MM-dd'T'HH:mm:ssX"))
//        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2018-05-01T10:08:16-0400");// ("yyyy-MM-dd'T'HH:mm:ssX"))
//        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2018-05-01T10:08:16-0400", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX"));// ("yyyy-MM-dd'T'HH:mm:ssX"))
//        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2018-05-01T14:08:16Z");
//        LocalDateTime zonedDateTime = LocalDateTime.parse("2002-01-01", DateTimeFormatter.ISO_LOCAL_DATE);
//        LocalDate zonedDateTime = LocalDate.parse("2002-03-04", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(zonedDateTime);
////        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(zonedDateTime));
////        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format((Temporal) zonedDateTime));
//        LocalDateTime localDateTime = zonedDateTime.atStartOfDay();
//        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime));
//        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format((Temporal) localDateTime));
////        long epochMilli3 = zonedDateTime.toInstant().toEpochMilli();
////        System.out.println(epochMilli3);

//        Date zonedDateTime = new SimpleDateFormat("yyyy-MM-dd").parse("2004-03-02");
//        Date zonedDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX").parse("2018-05-01T10:08:16-04:00");
//        Date zonedDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX").parse("2018-05-01T10:08:16Z");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
//        Date zonedDateTime = simpleDateFormat.parse("2018-05-01T10:08:16");
//        System.out.println(zonedDateTime);
//        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
//        zonedDateTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2018-05-01T10:08:16");
//        System.out.println(zonedDateTime);

//        for(String zone : TimeZone.getAvailableIDs()){
//            TimeZone timeZone = TimeZone.getTimeZone(zone);
//            System.out.println(timeZone.getID()+"\t"+timeZone.getRawOffset());
//        }
    }
}