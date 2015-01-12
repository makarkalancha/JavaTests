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
        integerTreeBinary.insert(new Integer(110));

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
////        System.out.println("find: " + integerTreeBinary.find(30));
////        integerTreeBinary.delete(40);
////        System.out.println("find: " + integerTreeBinary.find(30));
//
//
//        System.out.println("find: " + integerTreeBinary.find(50));
//        integerTreeBinary.delete(30);
//        System.out.println("find: " + integerTreeBinary.find(50));
//
////        integerTreeBinary.displayTree();
//        integerTreeBinary.inOrderTraversal();


        BTreePrinter.printNode(twenty);

    }
}
