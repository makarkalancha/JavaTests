package com.everything.locale;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Makar Kalancha
 * Date: 10/12/2017
 * Time: 10:32
 */
public class WeekTests {
    public static void main(String[] args) {
        int first = 1;
        int second = 3;
        int third = 6;
        List<Integer> weekDays = Arrays.asList(first, second, third);
        Collections.sort(weekDays);
        LocalDate start = LocalDate.of(2017, Month.DECEMBER, 12);
        int maxOccurrence = 7;
        int repeatEvery = 2;

        /////////////////////method
        List<LocalDate> result = new ArrayList<>(Arrays.asList(start));
        final int WEEK = 7;
        int cycle = WEEK * repeatEvery;

        List<Integer> cycleWeekDays = new ArrayList<>();
        cycleWeekDays.addAll(weekDays);
        cycleWeekDays.add(weekDays.get(0));

        LocalDate currentDate = start;
        System.out.println(currentDate.getDayOfWeek().getValue());
        //get closest index to start date week day
        Map<Integer, Integer> differenceToWeekDaysIndex = new HashMap<>();
//        BiMap<Integer, Integer> differenceToWeekDaysIndex = HashBiMap.create();
        for (int number = 0; number < weekDays.size(); number++) {
            int difference = (weekDays.get(number) - currentDate.getDayOfWeek().getValue() < 0) ?
                    cycle + weekDays.get(number) - currentDate.getDayOfWeek().getValue() :
                    weekDays.get(number) - currentDate.getDayOfWeek().getValue();

            differenceToWeekDaysIndex.put(difference, number);
        }
        System.out.println("differenceToIndex:" + differenceToWeekDaysIndex);
        Map.Entry<Integer, Integer> minEntry = differenceToWeekDaysIndex.entrySet().stream()
                .min((entry1, entry2) -> entry1.getKey().compareTo(entry2.getKey()))
                .orElse(null);
        System.out.println(String.format("minEntry: %s, %s", minEntry.getKey(), minEntry.getValue()));
        System.out.println("next day: " + weekDays.get(minEntry.getValue()));

        currentDate = currentDate.plus(minEntry.getKey(), ChronoUnit.DAYS);
        result.add(currentDate);

        List<Integer> daysToAdd = new ArrayList<>();
        int current = cycleWeekDays.get(0);

        for (int i = minEntry.getValue(); i < cycleWeekDays.size(); i++) {
            if(cycleWeekDays.get(i) > current) {
                daysToAdd.add(cycleWeekDays.get(i) - current);
            } else if (cycleWeekDays.get(i) < current){
                daysToAdd.add(cycleWeekDays.get(i) + cycle - current);
            }
            current = cycleWeekDays.get(i);
        }

//        start:2
//        diff:1
//        -(+1)->3-(+3)->6-(+2)->1-(+2)->3-(+3)->6....


        for (int i = minEntry.getValue(); result.size() < maxOccurrence; i++) {
            if(i >= daysToAdd.size()){
                i = 0;
            }
            currentDate = currentDate.plus(daysToAdd.get(i), ChronoUnit.DAYS);
            result.add(currentDate);
        }

        System.out.println(result);
    }
}
