package everything.strings;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Makar Kalancha
 * Date: 13 Oct 2016
 * Time: 14:34
 */
public class RemoveVowel {

    public static void main(String[] args) {
        System.out.println(removeVowel("CATEGORY_ID,TAX_ID,BENEFICIARY_ID,DESCRIPTION1"));
        System.out.println(removeVowel("CATEGORY_ID"));
        System.out.println(removeVowel("TAX_ID"));
        System.out.println(removeVowel("BENEFICIARY_ID"));
    }

    public static String removeVowel(String stringToClean){
        //https://simple.wikipedia.org/wiki/Vowel
        //        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'Y'};
        final String vowels = "AEIOUY_, ";
        stringToClean = stringToClean.toUpperCase();
        return StringUtils.replaceChars(stringToClean, vowels, "");
    }
}
