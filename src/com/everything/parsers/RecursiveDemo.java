package com.everything.parsers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by mcalancea
 * Date: 15 Jun 2018
 * Time: 13:08
 */
public class RecursiveDemo {

    private static final String LEVEL = "level";
    private static final String TIME = "time";
    private static final String STATISTIC = "statistic";

    public static void main(String[] args) {
        //level 86744; row Search, Smartphone, day&2017-12-31; value stat1=1, stat2=2
        //level 86744; row Search, Smartphone, day&2018-01-01; value stat1=1, stat2=2

        Request request = new Request();
        List<Wrapper> wrappers = new RecursiveDemo().parse(request.dimensionNames, request.dimensions, request.values);
    }

    private List<Wrapper> parse(String[] dimensionNames, String[][] dimensions, List<String> values){
        List<Wrapper> wrappers = new ArrayList<>();

        return wrappers;
    }

//    private Wrapper parseWrapper(){
//        Wrapper wrapper =
//    }


    private class Wrapper{
        private String accountId;
        private String time;
        private List<String> breakDowns;
        private Map<String, String> statValues;

        public Wrapper(String accountId, String time, List<String> breakDowns, Map<String, String> statValues) {
            this.accountId = accountId;
            this.time = time;
            this.breakDowns = breakDowns;
            this.statValues = statValues;
        }

        public String getAccountId() {
            return accountId;
        }

        public String getTime() {
            return time;
        }

        public List<String> getBreakDowns() {
            return breakDowns;
        }

        public Map<String, String> getStatValues() {
            return statValues;
        }
    }

    private static class Request{
        private String[] dimensionNames = {"level", "networkType", "deviceType", "time", "statistic"};
        private String[][] dimensions = {
                {"86744", "86544"},
                {"Search", "Content", "Mixed"},
                {"Smartphone"},
                {"day&2017-12-31", "day&2018-01-01"},
                {"stat1", "stat2"},
        };
//        private String[] values = {
        private List<String> values = Arrays.asList(
//        {
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
                "0", "1",
                "2", "3",
                "4", "5",
                "6", "7",
                "8", "9",
                "10", "11",
                "12", "13",
                "14", "15",
                "16", "17",
                "18", "19",
                "20", "21",
                "22", "23"
//        }
);

        public String[] getDimensionNames() {
            return dimensionNames;
        }

        public String[][] getDimensions() {
            return dimensions;
        }

        public List<String> getValues() {
            return values;
        }
    }
}
