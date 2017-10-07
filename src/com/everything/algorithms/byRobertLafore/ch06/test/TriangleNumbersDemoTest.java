package com.everything.algorithms.byRobertLafore.ch06.test;

import com.everything.algorithms.byRobertLafore.ch06.TriangleNumbersDemo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * User: Makar Kalancha
 * Date: 05/09/14
 * Time: 2:23 PM
 */
public class TriangleNumbersDemoTest {
    @Test
    public void testWithNumber1() {
        Assert.assertEquals(1, TriangleNumbersDemo.findTringleNumber(1));
    }

    @Test
    public void testWithNumberMinus10() {
        Assert.assertEquals(0, TriangleNumbersDemo.findTringleNumber(-10));
    }

    @Test
    public void testWithNumber1000() {
        Assert.assertEquals(500500, TriangleNumbersDemo.findTringleNumber(1000));
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TriangleNumbersDemoTest.class);
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
