package com.everything.strings;

import org.apache.commons.lang3.StringUtils;

/**
 * User: Makar Kalancha
 * Date: 03/03/2019
 * Time: 12:29
 */
public class CountCharacters {
    public static void main(String[] args) {
        String text1 = "{NUM}/(1+({TAX2}+{TAX5})/100)";
        String text2 = "{NUM}/(1+({TAX2}+{TAX5})/100";

        int numberOfOpeningParenthesis = StringUtils.countMatches(text2, "(");
        int numberOfClosingParenthesis = StringUtils.countMatches(text2, ")");
        System.out.println(numberOfOpeningParenthesis);
        System.out.println(numberOfClosingParenthesis);
    }
}
