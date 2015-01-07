package everything.algorithms.byRobertLafore.ch08;

/**
 * User: Makar Kalancha
 * Date: 06/01/2015
 * Time: 14:55
 */
public interface TreeInterface<T extends Comparable> {
    public Node<T> find(T key);
    public void insert(T key);
    public void delete(T key);
}
