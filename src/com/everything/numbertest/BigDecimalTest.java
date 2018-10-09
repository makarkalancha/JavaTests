package com.everything.numbertest;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Makar Kalancha
 * Date: 18 Apr 2017
 * Time: 08:50
 */
public class BigDecimalTest {
    public static void main(String[] args) {
//        BigDecimal one = null;
//        BigDecimal two = new BigDecimal("2");
//        System.out.println(one.compareTo(two));
//
//        String str = null;
//        BigDecimal three = new BigDecimal(str);
//        System.out.println(three);

        BigDecimal first = new BigDecimal("11.3");
        BigDecimal second = new BigDecimal("-1.05");
        BigDecimal third = first.multiply(second).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal forth = third.multiply(new BigDecimal("1.095")).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal fifth = new BigDecimal("16");
        BigDecimal sixth = new BigDecimal("15.56");
        BigDecimal seventh = new BigDecimal("15.46");
        BigDecimal eighth = new BigDecimal("15.36");
        System.out.println(forth);

        System.out.println(second.compareTo(BigDecimal.ZERO) == -1);

        MathContext mathContext = new MathContext(0, RoundingMode.UP);
        List<BigDecimal> bigDecimals = Arrays.asList(first, second, third, forth, fifth, sixth, seventh, eighth);
        for(BigDecimal number : bigDecimals) {
            System.out.println(number + "\t->\t" + /*number.round(mathContext) + "\t->\t" + */number.setScale(0, RoundingMode.HALF_UP));
        }
    }
}
