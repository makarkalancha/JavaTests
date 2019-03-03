package com.everything.java8tests.functionalprogramming.ch08.general;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;

/**
 * Created by mcalancea on 2015-11-20.
 */
public class YahooFinance {

    public static BigDecimal getPrice(final String ticker){
        try {
            final URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=" + ticker);
            final BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
//            final StringBuilder allData = new StringBuilder();
//            reader.lines()
//                    .forEach(line -> allData.append(line).append("\r\n"));
//            System.out.println(allData.toString());
            final String data = reader.lines().skip(1).findFirst().get();
            final String[] dataItems = data.split(",");
            return new BigDecimal(dataItems[dataItems.length - 1]);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
