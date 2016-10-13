package everything.strings;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Makar Kalancha
 * Date: 13 Oct 2016
 * Time: 14:34
 */
public class RemoveVowel {
    //https://simple.wikipedia.org/wiki/Vowel
    public static void main(String[] args) {
//        char[] vowels = {'A', 'E', 'I', 'O', 'U', 'Y'};
        String vowels = "AEIOUY";
        String stringToClean = "vowel".toUpperCase();
        String cleanedString = StringUtils.replaceChars(stringToClean, vowels, "");
        System.out.println(cleanedString);
    }
}
