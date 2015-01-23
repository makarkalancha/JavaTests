package everything.algorithms.byRobertLafore.ch11.chain;

import everything.algorithms.byRobertLafore.ch11.DataItemCh11;

/**
 * User: Makar Kalancha
 * Date: 23/01/2015
 * Time: 16:04
 */
public class Link <T extends Comparable> {
    private T iData;
    public Link<T> next;

    public Link(T data) {
        this.iData = data;
    }

    public T getKey() {
        return iData;
    }

    public void displayLink(){
        System.out.print(iData + " ");
    }
}
