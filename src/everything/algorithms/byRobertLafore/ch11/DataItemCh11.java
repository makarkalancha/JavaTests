package everything.algorithms.byRobertLafore.ch11;

/**
 * User: Makar Kalancha
 * Date: 20/01/2015
 * Time: 16:01
 */
public class DataItemCh11<T extends Comparable> {
    protected T iData;

    public DataItemCh11() {
    }

    public DataItemCh11(T data) {
        this.iData = data;
    }

    public T getKey() {
        return iData;
    }
    public boolean isNull(){
        return false;
    }

    @Override
    public String toString() {
        return "DataItemCh11{" +
                "iData=" + iData +
                '}';
    }
}
