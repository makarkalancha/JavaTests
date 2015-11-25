package everything.java8tests.functionalprogramming.ch08.mapreduce;

import everything.java8tests.functionalprogramming.ch08.general.Tickers;

/**
 * Created by mcalancea on 2015-11-24.
 */
public class Demo {

    public static void main(String[] args) {
        System.out.println("===============" + PickStockImperative.class.getSimpleName());
        PickStockImperative.main(null);
        System.out.println("===============" + PickStockImperativeClubbed.class.getSimpleName());
        PickStockImperativeClubbed.main(null);
        System.out.println("===============" + PickStockFunctional.class.getSimpleName());
        PickStockFunctional.findHighPriced(Tickers.symbols.stream());
        System.out.println("===============Parallel-" + PickStockFunctional.class.getSimpleName());
        PickStockFunctional.findHighPriced(Tickers.symbols.parallelStream());
    }

}
