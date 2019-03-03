package com.everything.java8tests.functionalprogramming.ch08.stockall;

import com.everything.java8tests.functionalprogramming.ch08.general.Tickers;
import com.everything.java8tests.functionalprogramming.ch08.general.YahooFinance;

/**
 * Created by mcalancea on 2015-11-24.
 */
public class StockAll {

    public static void main(String[] args) {
        System.out.println("Stocks : ");
        System.out.println(Tickers.symbols);
        Tickers.symbols
                .sort(
                        (symbol1, symbol2) -> symbol1.compareToIgnoreCase(symbol2)
                );
        Tickers.symbols
                .stream()
                .forEach(
                        symbol -> System.out.println(symbol + ": " + YahooFinance.getPrice(symbol))
                );
        System.out.println(Tickers.symbols);
    }
}
