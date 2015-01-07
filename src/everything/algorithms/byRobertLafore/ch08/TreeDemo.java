package everything.algorithms.byRobertLafore.ch08;

/**
 * User: Makar Kalancha
 * Date: 06/01/2015
 * Time: 14:57
 */
public class TreeDemo {
    public static void main(String[] args) {
        NodeCh08<Integer> twenty = new NodeCh08<>(20);

        TreeBinary<Integer> integerTreeBinary = new TreeBinary<Integer>(twenty);
        integerTreeBinary.insert(new Integer(10));
        integerTreeBinary.insert(new Integer(50));

        integerTreeBinary.insert(new Integer(30));
        integerTreeBinary.insert(new Integer(40));
        integerTreeBinary.insert(new Integer(100));
        integerTreeBinary.insert(new Integer(80));

//        integerTreeBinary.displayTree();

        integerTreeBinary.inOrderTraversal();

    }
}
