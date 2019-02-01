package com.everything.algorithms.byRobertSedgewick.ch1_1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p57_1_1_19 {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        for (int i = 0; i < 100; i++) {
            Date date = new Date();
            System.out.println("["+sdf.format(date)+"] "+i + ") Fibonacci=" + fibonacci(i));
        }
    }

    private static long fibonacci(int num){
        if(num == 0) return 0;
        if(num == 1) return 1;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
