package everything.algorithms.byRobertLafore.ch06;

import everything.algorithms.byRobertLafore.ch03.BubbleSort;

/**
 * User: Makar Kalancha
 * Date: 19/12/2014
 * Time: 13:50
 */
public class TowersOfHanoi {
    public static void main(String[] args) {
        doTowers(4,'A','B','C');
    }

    public static void doTowers(int topN, char from, char inter, char to){
        if(topN == 1) {
            System.out.println("Disk 1 from " + from + " to " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN + " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
}
