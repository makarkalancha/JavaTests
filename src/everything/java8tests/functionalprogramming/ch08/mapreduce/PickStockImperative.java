package everything.java8tests.functionalprogramming.ch08.mapreduce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import everything.java8tests.functionalprogramming.ch08.general.Tickers;
import everything.java8tests.functionalprogramming.utils.Wrapper;

/**
 * Created by mcalancea on 2015-11-24.
 */
public class PickStockImperative {

    public static void main(String[] args) {
        Wrapper.wrap(() -> {
            final int LESS_THAN = 500;
            final List<StockInfo> stocks = new ArrayList<>();
            for (String symbol : Tickers.symbols) {
                stocks.add(StockUtil.getPrice(symbol));
            }

            final List<StockInfo> stocksPricedUnder = new ArrayList<>();
            final Predicate<StockInfo> isPriceLessThan = StockUtil.isPriceLess(LESS_THAN);
            for (StockInfo stock : stocks) {
                if (isPriceLessThan.test(stock)) {
                    stocksPricedUnder.add(stock);
                }
            }

            StockInfo highPriced = new StockInfo("", BigDecimal.ZERO);
            for (StockInfo stock : stocksPricedUnder) {
                highPriced = StockUtil.pickHigh(highPriced, stock);
            }

            System.out.println("High priced under " + LESS_THAN + "$ is " + highPriced);
        });
    }

}
