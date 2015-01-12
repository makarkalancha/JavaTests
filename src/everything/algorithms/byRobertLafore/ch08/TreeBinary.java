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
        boolean isLeftNode = false;
        NodeCh08<T> current = _root;
        NodeCh08<T> previous = _root;
        while (current != null && key.compareTo(current.iData) != 0) {
            previous = current;
            if (key.compareTo(current.iData) == -1) {
                current = current.leftChild;
                isLeftNode = true;
            } else if (key.compareTo(current.iData) == 1) {
                current = current.rightChild;
                isLeftNode = false;
            }

//            if(key.compareTo(current.iData) == 0){
//                return null;
//            }
        }

        if (current.leftChild == null && current.rightChild == null) {
//            if(current.iData.compareTo(previous.iData) == -1){
            if(current == _root) {
                _root = null;
            }else if(isLeftNode){
                previous.leftChild = null;
            } else {
                previous.rightChild = null;
            }
        }else if (current.leftChild == null || current.rightChild == null) {
            if(current == _root) {
                _root = (current.leftChild == null) ? current.rightChild : current.leftChild;
            }else if(isLeftNode){
                previous.leftChild = (current.leftChild == null) ? current.rightChild : current.leftChild;
            } else {
                previous.rightChild = (current.leftChild == null) ? current.rightChild : current.leftChild;
            }
        } else {
            NodeCh08<T> successor = getSuccessor(current);
            if(current == _root){
                _root = successor;
            } else if (isLeftNode) {
                previous.leftChild = successor;
            } else {
                previous.rightChild = successor;
                successor.leftChild = current.leftChild;
            }
        }
    }

    private NodeCh08<T> getSuccessor(NodeCh08<T> delNode) {
        NodeCh08<T> successorParent = delNode;
        NodeCh08<T> successor = delNode;
        NodeCh08<T> current = delNode.rightChild;
        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    @Override
    public NodeCh08<T> find(T key) {
        NodeCh08<T> current = _root;
        while (current != null && current.iData.compareTo(key) != 0) {
            if (key.compareTo(current.iData) == -1) {
                current = current.leftChild;
            } else if (key.compareTo(current.iData) == 1) {
                current = current.rightChild;
            }

            if (current == null) {
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

    private T getMinimum(NodeCh08<T> root) {
        NodeCh08<T> current = root;
        NodeCh08<T> previous = root;
        while(current != null) {
            previous = current;
            current = current.leftChild;
        }
        return previous.iData;
    }

    public T getMinimum() {
        return getMinimum(_root);
    }

    public T getMaximum() {
        NodeCh08<T> current = _root;
        NodeCh08<T> previous = _root;
        while(current != null) {
            previous = current;
            current = current.rightChild;
        }
        return previous.iData;
    }
}
