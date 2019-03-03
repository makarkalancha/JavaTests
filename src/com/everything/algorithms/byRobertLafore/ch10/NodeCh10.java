package com.everything.algorithms.byRobertLafore.ch10;

/**
 * User: Makar Kalancha
 * Date: 15/01/2015
 * Time: 12:47
 */
public class NodeCh10<T extends Comparable> {
    private static final int ORDER = 4;
    private int numItems;
    private NodeCh10<T> parent;
    private NodeCh10<T>[] childArray = new NodeCh10[ORDER];
    private DataItemCh10<T>[] itemArray = new DataItemCh10[ORDER - 1];

    public void connectChild(int childNum, NodeCh10<T> child) {
        childArray[childNum] = child;
        if(child != null){
            child.parent = this;
        }
    }

    public NodeCh10<T> disconnectChild(int childNum) {
        NodeCh10<T> tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    public NodeCh10<T> getChild(int childNum) {
        return childArray[childNum];
    }

    public NodeCh10<T> getParent() {
        return parent;
    }

    public boolean isLeaf() {
        return (childArray[0] == null) ? true : false;
    }

    public int getNumItems() {
        return numItems;
    }

    public DataItemCh10<T> getItem(int index) {
        return itemArray[index];
    }

    public boolean isFull() {
        return (numItems == ORDER - 1) ? true : false;
    }

    public int findItem(T key) {
        for (int j = 0; j < ORDER - 1; j++) {
            if (itemArray[j] == null) {
                break;
            } else if (itemArray[j].dData.compareTo(key) == 0) {
                return j;
            }
        }
        return -1;
    }

    public int insertItem(DataItemCh10<T> newItem){
        numItems++;
        T newKey = newItem.dData;
        for (int j = ORDER - 2; j >= 0; j--) {
            if (itemArray[j] == null) {
                continue;
            } else {
                T itsKey = itemArray[j].dData;
                if (newKey.compareTo(itsKey) == -1) {
                    itemArray[j + 1] = itemArray[j];
                } else {
                    itemArray[j + 1] = newItem;
                    return j + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    public DataItemCh10<T> removeItem() {
        DataItemCh10<T> temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

//    @Override
//    public String toString() {
//        return "NodeCh10{" +
//                "childArray=" + Arrays.toString(childArray) +
//                ", numItems=" + numItems +
//                ", parent=" + parent +
//                ", itemArray=" + Arrays.toString(itemArray) +
//                '}';
//    }

    public void displayNode() {
        for (int i = 0; i < numItems; i++) {
            System.out.print(itemArray[i]);
        }
        System.out.println("/");
    }
}
