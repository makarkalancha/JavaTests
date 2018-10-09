package com.everything.strings;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Makar Kalancha
 * Date: 13 Oct 2016
 * Time: 14:34
 */
public class RemoveVowel {

    public static void main(String[] args) {
        System.out.println(removeVowel("CATEGORY_ID,\n" +
                "    TAX_ID,\n" +
                "    BENEFICIARY_ID,\n" +
                "    DESCRIPTION1,\n" +
                "    D_SUB_TOTAL,\n" +
                "    D_TOTAL,\n" +
                "    C_SUB_TOTAL,\n" +
                "    C_TOTAL ("));
    }

    public static String removeVowel(String stringToClean){
        //https://simple.wikipedia.org/wiki/Vowel
        //        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'Y'};
        final String vowels = "AEIOUY_, \n";
        stringToClean = stringToClean.toUpperCase();
        return StringUtils.replaceChars(stringToClean, vowels, "");
    }
}
