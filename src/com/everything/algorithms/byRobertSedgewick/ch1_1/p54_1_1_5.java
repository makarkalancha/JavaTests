package com.everything.algorithms.byRobertSedgewick.ch1_1;

/**
 * User: Makar Kalancha
 * Date: 08/05/14
 * Time: 11:02 AM
 */
public class p54_1_1_5 {
    public static void main(String[] args) {
        if(args.length == 2){
            try{
                double d0 = Double.parseDouble(args[0]);
                double d1 = Double.parseDouble(args[1]);
                if(isBetween0And1(d0) && isBetween0And1(d1)){
                    System.out.println("both between 0 and 1");
                } else{
                    System.out.println("NOT both between 0 and 1");
                }
            } catch (NumberFormatException e){
                System.out.println("not all doubles are parseable");
            }
        } else{
            System.out.println("not enough arguments");
        }
    }

    private static boolean isBetween0And1(double d){
        return (0 < d && d < 1);
    }

}
