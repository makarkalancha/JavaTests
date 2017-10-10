package com.everything.algorithms.exercises;

/**
 * User: Makar Kalancha
 * Date: 22/08/14
 * Time: 10:57 AM
 */
public class RoundString {
    //waterbottle
    //erbottlewat
    private static int count=0;

    public static void main(String[] args) {
        String s1 = "waterbottle";
//        String s2 = "erbottlewat";
        String s2 = "ewaterbottl";
//        String s2 = "terbottlewaq";
        String[] s2Arr = {
                "waterbottle",
                "aterbottlew",
                "terbottlewa",
                "erbottlewat",
                "rbottlewate",
                "bottlewater",
                "ottlewaterb",
                "ttlewaterbo",
                "tlewaterbot",
                "lewaterbott",
                "ewaterbottl",
                "ewarerbottl" //false
        };

////        System.out.println(isRound(s1,s2));
//        for(int i = 0;i < s2Arr.length ; i++){
//            System.out.println("=================================");
//            System.out.println(isRound(s1,s2Arr[i]));
//            count=0;
//        }

        for(int i = 0;i < s2Arr.length ; i++){
            System.out.println("=================================");
            System.out.println(isRoundShort(s1, s2Arr[i]));
        }
    } 
    public static boolean isRoundShort(String s1, String s2) {
        String tmp = s1.concat(s1);
        return tmp.contains(s2);
    }

    public static boolean isRound(String s1, String s2){
        if(s1.length() == s2.length()){
            for(int i = 0; i<s1.length(); i++){
                System.out.println(i+")");
                int j = (i > 0) ? (i-1) : (s1.length()-1);
                System.out.println("i="+i+";j="+j);
                if(s1.charAt(i)==s2.charAt(0) && s1.charAt(j)==s2.charAt(s2.length()-1)){

                    String tmp = s1.substring(i, s1.length())+s1.substring(0,i);
                    System.out.println(tmp+" ; ");
                    if(myEqualsIgnoreCase(tmp, s2)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }

    public static boolean myEqualsIgnoreCase(String s1, String s2){
        System.out.println("count:" + (++count) + " ; ");
        return s1.equalsIgnoreCase(s2);
    }
}
