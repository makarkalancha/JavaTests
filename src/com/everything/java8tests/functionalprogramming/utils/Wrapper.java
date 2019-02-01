package com.everything.java8tests.functionalprogramming.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mcalancea on 2015-11-24.
 */
public class Wrapper {

    private static final String format = "dd/MMM/YYYY HH:mm:ss.S";
    public static void wrap(RunFunction runFunction){
        long start = 0L;
        long end = 0L;
        Date startDate = new Date();
        Date endDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        start = System.currentTimeMillis();
        runFunction.runIt();
        end = System.currentTimeMillis();
        startDate.setTime(start);
        endDate.setTime(end);
        System.out.println("start: " + sdf.format(startDate));
        System.out.println("end: " + sdf.format(endDate));
        System.out.println("lasted (ms): " + (end - start));
    }

}
