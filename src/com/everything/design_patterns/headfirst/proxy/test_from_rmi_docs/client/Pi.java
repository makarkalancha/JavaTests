package com.everything.design_patterns.headfirst.proxy.test_from_rmi_docs.client;

import com.everything.design_patterns.headfirst.proxy.test_from_rmi_docs.compute.Task;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * User: Makar Kalancha
 * Date: 25/09/14
 * Time: 4:52 PM
 */
public class Pi implements Task<BigDecimal>,Serializable {
    private static final long serialVersionUID = 227L;

    //constans used in pi computation
    private static final BigDecimal FOUR = BigDecimal.valueOf(4);
    //rounding mode to use during pi computation
    private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;
    //digits of precision after the decimal point
    private final int digits;

    public Pi(int digits) {
        this.digits = digits;
    }

    @Override
    public BigDecimal execute() {
        return computePi(digits);
    }

    public static BigDecimal computePi(int digits) {
        int scale = digits + 5;
        BigDecimal arctan1_5 = arctan(5, scale);
        BigDecimal arctan1_239 = arctan(239, scale);
        BigDecimal pi = arctan1_5.multiply(FOUR).subtract(arctan1_239).multiply(FOUR);
        return pi.setScale(digits, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal arctan(int inverseX, int scale){
        BigDecimal result, numer, term;
        BigDecimal invX = BigDecimal.valueOf(inverseX);
        BigDecimal invX2 = BigDecimal.valueOf(inverseX * inverseX);

        numer = BigDecimal.ONE.divide(invX, scale, roundingMode);

        result = numer;
        int i = 1;
        do {
            numer = numer.divide(invX2, scale, roundingMode);
            int denom = 2 * i + 1;
            term = numer.divide(BigDecimal.valueOf(denom), scale, roundingMode);
            if ((i % 2) != 0) {
                result = result.subtract(term);
            } else {
                result = result.add(term);
            }
            i++;
        } while (term.compareTo(BigDecimal.ZERO) != 0);
        return result;
    }
}
