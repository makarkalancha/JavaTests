package everything.java8tests.functionalprogramming.ch08.mapreduce;

import java.util.stream.Stream;
import everything.java8tests.functionalprogramming.utils.Wrapper;

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
