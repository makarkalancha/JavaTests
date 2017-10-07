package com.everything.algorithms.byRobertSedgewick.ch1_1.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Makar Kalancha
 * Date: 29/05/14
 * Time: 4:12 PM
 */
public class TestRunner {
    public static void main(String[] args) {
//        testClassp58_1_1_21_test();
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        testClassp58_1_1_22_test();
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
    }

    private static void testClassp58_1_1_21_test(){
        Result result = JUnitCore.runClasses(p58_1_1_21_test.class);
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
        System.out.println("test runtime: "+sdf.format(new Date(result.getRunTime())));

        System.out.println("test count: "+result.getRunCount());

        System.out.println("was test successful? "+result.wasSuccessful());
    }

    private static void testClassp58_1_1_22_test(){
        Result result = JUnitCore.runClasses(p58_1_1_22_test.class);
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }

        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS");
        System.out.println("test runtime: "+sdf.format(new Date(result.getRunTime())));

        System.out.println("test count: "+result.getRunCount());

        System.out.println("was test successful? "+result.wasSuccessful());
    }
}
