package com.everything.parsers;

/**
 * Created by mcalancea
 * Date: 15 Jun 2018
 * Time: 13:08
 */
public class RecursiveDemo {
    private String[] dimensionNames = {"level", "networkType", "deviceType", "time", "statistic"};
    private String[][] dimensions = {
            {"86744", "86544"},
            {"Search", "Content", "Mixed"},
            {"Smartphone"},
            {"day&2017-12-31", "day&2018-01-01"},
            {"stat1", "stat2"},
    };
    private String[] values = {
//            "0", "0",
//            "0", "0",
//            "0", "0",
//            "0", "0",
//            "0", "0",
//            "0", "0",
//            "0", "0",
//            "2", "0.49695420625",
//            "0", "0",
//            "0", "0",
//            "0", "0",
//            "0", "0"
            "1", "2",
            "3", "4",
            "5", "6",
            "7", "8",
            "9", "10",
            "11", "12",
            "13", "14",
            "15", "16",
            "17", "18",
            "19", "20",
            "21", "22",
            "23", "24"
    };

    public static void main(String[] args) {
        //level 86744; row Search, Smartphone, day&2017-12-31; value stat1=1, stat2=2
        //level 86744; row Search, Smartphone, day&2018-01-01; value stat1=1, stat2=2

        Map<Level, Row, stat>
                stat
    }


}
