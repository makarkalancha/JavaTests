package everything.algorithms.byRobertLafore.ch10;

/**
 * User: Makar Kalancha
 * Date: 15/01/2015
 * Time: 13:30
 */
public class Tree234<T extends Comparable> {
    private NodeCh10<T> root = new NodeCh10<>();

    public int find(T key) {
        NodeCh10<T> curNode = root;
        int childNumber;
        while(true) {
//            childNumber = curNode.findItem(key);
            if ((childNumber = curNode.findItem(key)) != -1) {
                return childNumber;
            } else if(curNode.isLeaf()){
                return -1;
            } else {
                curNode = getNextChild(curNode, key);
            }
        }
    }

    public void insert(T dValue){
        NodeCh10<T> curNode = root;
        DataItemCh10<T> tempItem = new DataItemCh10<>(dValue);

        while(true){
            if(curNode.isFull()){
                split(curNode);
                curNode = curNode.getParent();

                curNode = getNextChild(curNode, dValue);
            } else if(curNode.isLeaf()) {
                break;
            } else {
                curNode = getNextChild(curNode,dValue);
            }
        }
        curNode.insertItem(tempItem);
    }

    public void split(NodeCh10<T> thisNode){
        DataItemCh10<T> itemB;
        DataItemCh10<T> itemC;

        NodeCh10<T> parent;
        NodeCh10<T> child2;
        NodeCh10<T> child3;

        int itemIndex;

        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);

        NodeCh10<T> newRight = new NodeCh10<>();

        if(thisNode == root){
            root = new NodeCh10<>();
            parent = root;
            root.connectChild(0, thisNode);
        } else {
            parent = thisNode.getParent();
        }

        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        for (int j = n - 1; j > itemIndex; j--) {
            NodeCh10<T> temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }

        parent.connectChild(itemIndex + 1, newRight);

        newRight.insertItem(itemC);
        newRight.connectChild(0,child2);
        newRight.connectChild(1,child3);
    }

    public NodeCh10<T> getNextChild(NodeCh10<T> theNode, T theValue){
        int j;
        int numItems = theNode.getNumItems();
        for (j = 0; j < numItems; j++) {
            if (theValue.compareTo(theNode.getItem(j).dData) == -1) {
                return theNode.getChild(j);
            }
        }
        return theNode.getChild(j);
    }

    public void displayTree(){
        recDisplayTree(root, 0 , 0);
    }

    private void recDisplayTree(NodeCh10<T> thisNode, int level, int childNumber){
        System.out.print("level=" + level + " child=" + childNumber + " ");
        thisNode.displayNode();

        int numItems = thisNode.getNumItems();
        for (int j = 0; j < numItems + 1; j++) {
            NodeCh10<T> nextNode = thisNode.getChild(j);
            if (nextNode != null) {
                recDisplayTree(nextNode, level + 1, j);
            } else {
                return;
            }
        }
    }
}
