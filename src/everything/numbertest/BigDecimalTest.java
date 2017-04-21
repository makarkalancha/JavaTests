package everything.numbertest;

import java.math.BigDecimal;

/**
 * Created by Makar Kalancha
 * Date: 18 Apr 2017
 * Time: 08:50
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal one = null;
        BigDecimal two = new BigDecimal("2");
        System.out.println(one.compareTo(two));

        String str = null;
        BigDecimal three = new BigDecimal(str);
        System.out.println(three);

    }
}
