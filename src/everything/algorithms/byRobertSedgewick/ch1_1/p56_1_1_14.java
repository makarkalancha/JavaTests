package everything.algorithms.byRobertSedgewick.ch1_1;

import java.util.Random;

/**
 * User: Makar Kalancha
 * Date: 09/05/14
 * Time: 3:58 PM
 */
public class p56_1_1_14 {

    public static void main(String[] args) {
        int n = 2;
        System.out.println("check lg2("+n+")="+checkLg(256,2));
//        System.out.println("check lg2("+n+")="+Math.log10(1000));
        System.out.println("lg="+lg(n));

        Random r = new Random();
        for(int i = 0;i<10;i++) {
            int value = r.nextInt(Integer.MAX_VALUE);
            System.out.println(i+") "+value+": "+lg(value));
        }
    }

    private static int checkLg(int arg,int base) {
        return (int) (Math.log10(arg) / Math.log10(base));
    }

    private static int lg(int arg){
        if(arg <= 0) {
            return 0;
        }
        return 31 - (32-Integer.toBinaryString(arg).length());
    }

}
