package com.everything.java8tests.functionalprogramming.ch04.calculator;

import java.math.BigDecimal;
import java.util.function.Function;

/**
 * User: Makar Kalancha
 * Date: 22/01/2016
 * Time: 21:07
 */
public class CalculateNAV {
    Function<String, BigDecimal> priceFinder;

    public CalculateNAV(final Function<String, BigDecimal> aPriceFinder) {
        priceFinder = aPriceFinder;
    }

    public BigDecimal computeStockWorth(final String ticker, final int shares) {
        return priceFinder.apply(ticker).multiply(BigDecimal.valueOf(shares));
    }

    public static void main(String[] args) {
        final int qty = 1;
        CalculateNAV nav = new CalculateNAV(YahooFinance::getPrice);
        System.out.println(String.format(qty+" share(s) of Google worth: $%.2f",
                nav.computeStockWorth("GOOG",qty)));
    }
}
