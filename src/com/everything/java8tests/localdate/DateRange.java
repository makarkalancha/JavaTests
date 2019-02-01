package com.everything.java8tests.localdate;

import java.time.LocalDate;

/**
 * Created by mcalancea
 * Date: 18 Dec 2018
 * Time: 15:20
 */
public class DateRange {
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

    @Override
    public String toString() {
        return "DateRange{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}