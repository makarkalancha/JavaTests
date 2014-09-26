package everything.algorithms;

import java.util.*;

/**
 * User: Makar Kalancha
 * Date: 06/03/14
 * Time: 1:14 PM
 */
public class BinarySearch extends Search {
//    private static SimpleDateFormat LOG_TIME_FORMAT = new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss:SS");

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int _needle = 100;
        System.out.println(LOG_TIME_FORMAT.format(new Date()) + ": find needle = " + _needle);


        System.out.println(LOG_TIME_FORMAT.format(new Date()) + ": _hayStackManual");
        Integer[] _hayStackManual = {1, 2, 5, 8, 10, 33, 64, 80, 100};
        System.out.println(binarySearch.find(_hayStackManual, _needle));

        System.out.println("===============================================");

        System.out.println(LOG_TIME_FORMAT.format(new Date()) + ": _hayStackBigLoop");
        Integer[] _hayStackBigLoop = new Integer[100];
        for (int i = 0; i < _hayStackBigLoop.length; i++) {
            _hayStackBigLoop[i] = i + 1;
        }
        System.out.println(binarySearch.find(_hayStackBigLoop, _needle));

        System.out.println("===============================================");

        System.out.println(LOG_TIME_FORMAT.format(new Date()) + ": _hayStackReallyBigRandom");
        int sizeOfHayStackReallyBigRandom = 1_000_000;
        Integer[] _hayStackReallyBigRandom = new Integer[sizeOfHayStackReallyBigRandom];
        TreeSet<Integer> treeSetInteger = new TreeSet<Integer>();
        Random random = new Random();
        int randomEnd = 10_000_000;
        while (treeSetInteger.size() < _hayStackReallyBigRandom.length) {
            treeSetInteger.add(random.nextInt(randomEnd));
        }
        System.out.println(LOG_TIME_FORMAT.format(new Date()) + ": end of filling the set");
        _hayStackReallyBigRandom = treeSetInteger.toArray(new Integer[_hayStackReallyBigRandom.length]);
//        System.out.println(Arrays.toString(_hayStackReallyBigRandom));
        System.out.println(binarySearch.find(_hayStackReallyBigRandom, _needle));

        System.out.println(LOG_TIME_FORMAT.format(new Date()) + ": end!!!");


    }

    public int find(Integer[] hayStack, int needle){
        int result = -1;
        int lowerBound = 0;
        int upperBound = hayStack.length-1;
        int step = 0;
        Date start = new Date();
        while(lowerBound <= upperBound) {
//            System.out.println(LOG_TIME_FORMAT.format(new Date())+": step #"+(++step));
            ++step;
            int currentInd = (lowerBound + upperBound) / 2;
            if (hayStack[currentInd] == needle) {
                System.out.println(LOG_TIME_FORMAT.format(new Date())+": step #"+step);
                Date end = new Date();
                timeSpeed(start, end);
                return currentInd;
            } else {
                if (hayStack[currentInd] > needle) {
                    upperBound = currentInd - 1;
                } else {
                    lowerBound = currentInd + 1;
                }
            }
        }
        System.out.println(LOG_TIME_FORMAT.format(new Date())+": step #"+step);
        Date end = new Date();
        timeSpeed(start,end);
        return result;
    }

}
