package com.everything;

/**
 * User: Makar Kalancha
 * Date: 08/05/14
 * Time: 10:31 AM
 */
public class ForTest {
    public static void main(String[] args) {
        for (int i = 0; i < 0; i++) {
            System.out.println(i);
        }

        System.out.println("a)(1 + 2.236)/2="+((1 + 2.236)/2));
        System.out.println("b)1 + 2 + 3 + 4.0="+(1 + 2 + 3 + 4.0));
        System.out.println("c)4.1 >= 4="+(4.1 >= 4));
        System.out.println("d)1 + 2 + \"3\"="+(1 + 2 + "3"));


        int count = -1;
        do {
            System.out.println("in the loop count = " + count);
            count--;
        } while (count >= 0);
        System.out.println("outside of the loop count = " + count);
    }
}
