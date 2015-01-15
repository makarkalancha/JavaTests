package everything.algorithms.byRobertLafore.ch10;

/**
 * User: Makar Kalancha
 * Date: 15/01/2015
 * Time: 12:45
 */
public class DataItem<T extends Comparable> {
    public T dData;

    public DataItem(T dd){
        this.dData = dd;
    }

    @Override
    public String toString() {
        return "/" + dData ;
    }
}
