package com.everything.java8tests.functionalprogramming.ch08.mapreduce;

import com.everything.java8tests.functionalprogramming.ch08.general.Tickers;
import com.everything.java8tests.functionalprogramming.utils.Wrapper;

import java.math.BigDecimal;
import java.util.function.Predicate;

/**
 * Created by mcalancea on 2015-11-24.
 */
public class PickStockImperativeClubbed {

    public static void main(String[] args) {
        Wrapper.wrap(() -> {
            final int LESS_THAN = 500;
            StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);
            final Predicate<StockInfo> isPriceLessThan = StockUtil.isPriceLess(LESS_THAN);
            for (String symbol : Tickers.symbols) {
                StockInfo stock = StockUtil.getPrice(symbol);
                if (isPriceLessThan.test(stock)) {
                    highPriced = StockUtil.pickHigh(highPriced, stock);
                }
            }

            System.out.println("High priced under " + LESS_THAN + "$ is " + highPriced);
        });
    }
}
