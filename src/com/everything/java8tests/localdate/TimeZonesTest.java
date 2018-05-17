package com.everything.java8tests.localdate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by mcalancea
 * Date: 04 May 2018
 * Time: 11:30
 */
public class TimeZonesTest {
    public static void main(String[] args) {
        Set<String> allZones = ZoneId.getAvailableZoneIds();
        LocalDateTime localDateTime = LocalDateTime.now();

        List<String> allZoneList = new ArrayList<>(allZones);
        Collections.sort(allZoneList);

        for(String s : allZoneList){
            ZoneId zoneId = ZoneId.of(s);
            ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
            ZoneOffset zoneOffset = zonedDateTime.getOffset();
//            int secondsOfHour = zoneOffset.getTotalSeconds()
            String offset = String.format("%35s %10s%n", zoneId, zoneOffset);

            System.out.print(offset);
        }
    }
}
