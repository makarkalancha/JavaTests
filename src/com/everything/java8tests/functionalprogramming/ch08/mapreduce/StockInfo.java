package com.everything.java8tests.functionalprogramming.ch08.mapreduce;

import java.math.BigDecimal;

/**
 * Created by mcalancea on 2015-11-24.
 */
public class StockInfo {
    public final String ticker;
    public final BigDecimal price;

    public StockInfo(final String symbol, final BigDecimal thePrice){
        ticker = symbol;
        price = thePrice;
    }

    @Override
    public String toString() {
        return String.format("ticker: %s price: %g", ticker, price);
    }
}
