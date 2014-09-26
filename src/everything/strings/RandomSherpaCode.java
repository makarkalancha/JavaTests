package everything.strings;

import everything.utils.RandomNumbers;

import java.util.Arrays;

/**
 * User: Makar Kalancha
 * Date: 06/06/14
 * Time: 12:18 PM
 */
public class RandomSherpaCode {
    public static void main(String[] args) {
        char[] array = new char[10+26+26];
        for(int j=0, i = 48; i < 123; i++, j++) {
//            if(i==58) {
//                i = 65;
//            } else
            switch (i){
                case 58: i=65; break;
                case 91: i=97; break;
                default: break;
            }

            array[j] = (char)i;
        }
        System.out.println(Arrays.toString(array));
        StringBuilder sherpaCode = new StringBuilder();
        for (int k = 0; k < 9; k++) {
            sherpaCode.append(array[RandomNumbers.getRandomIntNumber(0, array.length-1)]);
        }
        System.out.println(sherpaCode);
    }
}
