package com.everything.numbertest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.math.BigDecimal;

/**
 * Created by mcalancea on 2015-12-15.
 */
public class NumberUtilTest {

    public static void main(String[] args) {
        final String TEN = "10";
        final String TEN_WITH_FRACTION = "10.0004999";
        System.out.println(NumberUtils.toInt(TEN_WITH_FRACTION));
        System.out.println(NumberUtils.toInt(TEN));
//        System.out.println(Integer.parseInt(TEN_WITH_FRACTION));
        System.out.println(Integer.parseInt(TEN));

        System.out.println(convertBidModifierToPercentage(Double.parseDouble(TEN_WITH_FRACTION)));
    }

    public static Integer convertBidModifierToPercentage(Double bidModifier) {
        Integer bidPercentage = 0;
        final int percentageMultiplier = 100;

        if (bidModifier != null) {
            if (bidModifier > 1.0) {
                bidPercentage = new BigDecimal(((bidModifier - 1) / 1.0) * percentageMultiplier)
                        .setScale(0, BigDecimal.ROUND_HALF_EVEN).intValue();
            } else if (bidModifier == 1.0) {
                bidPercentage = 0;
            } else if (bidModifier == 0.0) {
                bidPercentage = -percentageMultiplier;
            } else if (bidModifier > 0.0) {  // > 0.0 and < 1.0
                bidPercentage = new BigDecimal(((bidModifier - 1) / 1.0) * percentageMultiplier)
                        .setScale(0, BigDecimal.ROUND_HALF_EVEN).intValue();
            } else if (bidModifier == -1.0) {
                bidPercentage = 0;
            }
        }
        return bidPercentage;
    }

    public static Double convertPercentageToBidModifier(String bidModifier) {
        int bidPercentage = NumberUtils.toInt(StringUtils.remove(bidModifier, "+"));
        return convertPercentageToBidModifier(bidPercentage);
    }

    public static Double convertPercentageToBidModifier(int bidPercentage) {
        BigDecimal bid = new BigDecimal(0);
        final int percentageMultiplier = 100;
        final int scale = 16;

        if (bidPercentage < 0 && bidPercentage > -percentageMultiplier) { // ==> 0.
            bid = new BigDecimal(1 - ((bidPercentage * (1.0) * (-1)) / percentageMultiplier));
        } else if (bidPercentage == 0) {
            bid = new BigDecimal(1.0);
        } else if (bidPercentage == -percentageMultiplier) {
            bid = new BigDecimal(0.0);
        } else if (bidPercentage > 0) {
            bid = new BigDecimal((bidPercentage * (1.0)) / percentageMultiplier + 1);
        }
        return bid.setScale(scale, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }

}
