package everything.algorithms.byRobertLafore.ch08;

/**
 * User: Makar Kalancha
 * Date: 06/01/2015
 * Time: 14:57
 */
public class TreeDemo {
    public static void main(String[] args) {
//        NodeCh08<Integer> twenty = new NodeCh08<>(20);
//
//        TreeBinary<Integer> integerTreeBinary = new TreeBinary<Integer>(twenty);
//        integerTreeBinary.insert(new Integer(10));
//        integerTreeBinary.insert(new Integer(50));
//
//        integerTreeBinary.insert(new Integer(30));
//        integerTreeBinary.insert(new Integer(40));
//        integerTreeBinary.insert(new Integer(100));
//        integerTreeBinary.insert(new Integer(80));
//        integerTreeBinary.insert(new Integer(110));
//
//        integerTreeBinary.displayTree();

//        System.out.println("find: " + integerTreeBinary.find(100));
//
////        integerTreeBinary.displayTree();
//
//        integerTreeBinary.inOrderTraversal();
//
//        System.out.println();
//        System.out.println("min: "+integerTreeBinary.getMinimum());
//        System.out.println("max: "+integerTreeBinary.getMaximum());
//
////        integerTreeBinary.displayTree();
//        integerTreeBinary.inOrderTraversal();

//        integerTreeBinary.delete(10);
//        integerTreeBinary.displayTree();

//        integerTreeBinary.delete(20);
//        integerTreeBinary.displayTree();
//
//        integerTreeBinary.delete(30);
//        integerTreeBinary.displayTree();
//
//        integerTreeBinary.delete(40);
//        integerTreeBinary.displayTree();
//
//        integerTreeBinary.delete(50);
//        integerTreeBinary.displayTree();
//
//        integerTreeBinary.delete(80);
//        integerTreeBinary.displayTree();
//
//        integerTreeBinary.delete(100);
//        integerTreeBinary.displayTree();
//
//        integerTreeBinary.delete(110);
//        integerTreeBinary.displayTree();

        NodeCh08<Integer> root1 = new NodeCh08<>(17);
        TreeBinary<Integer> integerTreeBinary1 = new TreeBinary<Integer>(root1);
        integerTreeBinary1.insert(new Integer(21));
        integerTreeBinary1.insert(new Integer(28));
        integerTreeBinary1.insert(new Integer(36));
        integerTreeBinary1.displayTree();

        NodeCh08<Integer> root2 = new NodeCh08<>(36);
        TreeBinary<Integer> integerTreeBinary2 = new TreeBinary<Integer>(root2);
        integerTreeBinary2.insert(new Integer(28));
        integerTreeBinary2.insert(new Integer(21));
        integerTreeBinary2.insert(new Integer(17));
        integerTreeBinary2.displayTree();
    }
}
