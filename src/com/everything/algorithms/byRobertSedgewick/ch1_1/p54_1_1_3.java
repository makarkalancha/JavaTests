package com.everything.algorithms.byRobertSedgewick.ch1_1;

/**
 * User: Makar Kalancha
 * Date: 08/05/14
 * Time: 11:02 AM
 */
public class p54_1_1_3 {
    public static void main(String[] args) {
        if(args.length == 3){
            try{
                int i0 = Integer.parseInt(args[0]);
                int i1 = Integer.parseInt(args[1]);
                int i2 = Integer.parseInt(args[2]);
                if(i0==i1 && i0==i2){
                    System.out.println("equal");
                } else{
                    System.out.println("NOT equal");
                }
            } catch (NumberFormatException e){
                System.out.println("not all ints are parseable");
            }
        } else{
            System.out.println("not enough arguments");
        }
    }

}
