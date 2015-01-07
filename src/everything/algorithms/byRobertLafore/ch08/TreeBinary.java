package everything.algorithms.byRobertLafore.ch08;

/**
 * User: Makar Kalancha
 * Date: 06/01/2015
 * Time: 14:58
 */
public class TreeBinary<T extends Comparable> extends AbstractTree<T> {
    public TreeBinary(NodeCh08<T> root) {
        super(root);
    }

    @Override
    public void delete(T key) {
        System.out.println("NOT implemented yet!");
    }

    @Override
    public NodeCh08<T> find(T key) {
        NodeCh08<T> current = _root;
        while (current.iData.equals(key)) {
            if (key.compareTo(current.iData) == -1) {
                current = _root.leftChild;
            } else if (key.compareTo(current.iData) == 1) {
                current = _root.rightChild;
            }

            if(current == null){
                return null;
            }

        }
        return current;
    }

    @Override
    public void insert(T key) {
        NodeCh08<T> newNode = new NodeCh08(key);

        NodeCh08<T> current = _root;
        NodeCh08<T> previous = _root;
        while (current != null) {
            previous = current;
            if (key.compareTo(current.iData) == -1) {
                current = current.leftChild;
            } else if (key.compareTo(current.iData) == 1) {
                current = current.rightChild;
            } else {
                return;
            }
        }

        if (key.compareTo(previous.iData) == -1) {
            previous.leftChild = newNode;
        } else if (key.compareTo(previous.iData) == 1) {
            previous.rightChild = newNode;
        }
    }

    //// An inorder traversal of a binary search tree will cause all the nodes to be visited in
    //// ascending order, based on their key values
    public void inOrderTraversal() {
//        System.out.println(inOrderTraversalMine(_root));
        inOrderTraversalBook(_root);
    }

    private String inOrderTraversalMine(NodeCh08<T> current) {
        if (current == null) {
            return "";
        }
        return inOrderTraversalMine(current.leftChild) + " ; " + current.iData + " ; " + inOrderTraversalMine(current.rightChild);
    }

    private void inOrderTraversalBook(NodeCh08<T> current) {
        if (current != null) {
            inOrderTraversalBook(current.leftChild);
            System.out.print(current.iData + " ; ");
            inOrderTraversalBook(current.rightChild);
        }
    }
}
