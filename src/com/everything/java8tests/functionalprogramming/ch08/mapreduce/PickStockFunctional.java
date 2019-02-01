package com.everything.java8tests.functionalprogramming.ch08.mapreduce;

import com.everything.java8tests.functionalprogramming.utils.Wrapper;

import java.util.stream.Stream;

/**
 * Created by mcalancea on 2015-11-24.
 */
public class PickStockFunctional {

    private final static int LESS_THAN = 500;

    public static void findHighPriced(final Stream<String> symbols) {
        Wrapper.wrap(() -> {
            final StockInfo highPriced =
                    symbols
                            .map(StockUtil::getPrice)
                            .filter(StockUtil.isPriceLess(LESS_THAN))
                            .reduce(StockUtil::pickHigh)
                            .get();
            System.out.println("High priced under " + LESS_THAN + "$ is " + highPriced);
        });
    }
}
