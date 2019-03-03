package com.everything.algorithms.byRobertLafore.ch06;

import org.apache.log4j.Logger;

/**
 * User: Makar Kalancha
 * Date: 05/09/14
 * Time: 2:10 PM
 */
public class TriangleNumbersDemo {
    public static final Logger LOG = Logger.getLogger(TriangleNumbersDemo.class);

    public static void main(String[] args) {
        for(int i = 0;i < 10;i++){
            System.out.println(i+":"+findTringleNumber(i));
        }
//        System.out.println(findTringleNumber(1000));

//        System.out.println(findTringleNumberDirty(10));


    }

    public static int findTringleNumber(int number){
        int result = 0;
        LOG.debug("entering " + number);
        if(number == 1){
            LOG.debug("returning 1");
            return 1;
        } else if(number > 1){
            result = number + findTringleNumber(number - 1);
            LOG.debug("returning " + result);
            return result;
        }else {
            return result;
        }
    }

//    public static int findTringleNumber(int number){
//        int result = 0;
//        if(number == 1){
//            return 1;
//        } else if(number > 1){
//            return number + findTringleNumber(number - 1);
//        }else {
//            return result;
//        }
//    }
//
//    public static int findTringleNumberDirty(int number){
//        int result = 0;
//        System.out.println("entering "+number);
//        if(number == 1){
//            System.out.println("returning 1");
//            return 1;
//        } else if(number > 1){
//            result = number + findTringleNumberDirty(number - 1);
//            System.out.println("returning "+result);
//            return result;
//        }else {
//            return result;
//        }
//    }

}
