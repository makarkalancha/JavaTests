package com.everything.strings;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Makar Kalancha
 * Date: 13 Oct 2016
 * Time: 14:34
 */
public class RemoveVowel {

    public static void main(String[] args) {
        System.out.println(removeVowel("change_logs~hierarchy_revision_id, table_name, table_id"));
        System.out.println(removeVowel("EST_GROUP_AREA_HIST~EST_SERVICE_AREA_HIST_ID"));
    }

    public static String removeVowel(String stringToClean){
        //https://simple.wikipedia.org/wiki/Vowel
        //        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'Y'};
        final String vowels = "AEIOUY_, ";
        stringToClean = stringToClean.toUpperCase();
        stringToClean = StringUtils.replaceChars(stringToClean, vowels, "");
        return stringToClean.replace("~", "_");
    }
}
