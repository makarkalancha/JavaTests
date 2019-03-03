package com.everything.downloadqueue;

//import java.lang.management.ManagementFactory;
//import java.lang.management.OperatingSystemMXBean;


import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * User: Makar Kalancha
 * Date: 07/04/14
 * Time: 1:25 PM
 */
public class ProcessLoad {
    public static void main(String[] args) {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);
//        System.out.println(osBean.getProcessCpuLoad());
//        System.out.println(osBean.getSystemCpuLoad());
        System.out.println(osBean.getSystemLoadAverage());
        System.out.println(osBean.getAvailableProcessors());
    }
}
