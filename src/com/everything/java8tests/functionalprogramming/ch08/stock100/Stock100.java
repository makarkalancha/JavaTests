package com.everything.java8tests.functionalprogramming.ch08.stock100;

import com.everything.java8tests.functionalprogramming.ch08.general.Tickers;
import com.everything.java8tests.functionalprogramming.ch08.general.YahooFinance;

import java.math.BigDecimal;

import static java.util.stream.Collectors.joining;

/**
 * Created by mcalancea on 2015-11-20.
 */
public class Stock100 {

    public static void main(String[] args) {
        final BigDecimal HUNDRED = new BigDecimal("100");
        System.out.println("Stocks priced over $100 are: "+
            Tickers.symbols
                .stream()
                .filter(
                        symbol -> YahooFinance.getPrice(symbol).compareTo(HUNDRED) > 0
                )
                .sorted()
                .collect(joining(", "))
        );
    }

}
