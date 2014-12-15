package everything.algorithms.tree;

import java.util.Arrays;

/**
 * User: Makar Kalancha
 * Date: 15/12/2014
 * Time: 15:05
 */
public class Node {
    private String _name;
    private Node[] _children;

    public Node(String name) {
        this._name = name;
    }

    public Node(String name, Node[] children) {
        this(name);
        this._children = children;
    }

    public String getName() {
        return _name;
    }

    public Node[] getChildren() {
        return _children;
    }

    @Override
    public String toString() {
//        return "Node{" +
//                "_children=" + Arrays.toString(_children) +
//                ", _name='" + _name + '\'' +
//                '}';
        return _name;
    }
}
