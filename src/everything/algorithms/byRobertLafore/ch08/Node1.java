package everything.algorithms.byRobertLafore.ch08;

/**
 * User: Makar Kalancha
 * Date: 06/01/2015
 * Time: 14:51
 */
public class Node1<T> {
    public T iData;
    public Node1 leftChild;
    public Node1 rightChild;

    public Node1(T data) {
        iData = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "iData=" + iData +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}


