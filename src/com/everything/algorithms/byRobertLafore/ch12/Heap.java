package com.everything.algorithms.byRobertLafore.ch12;

/**
 * User: Makar Kalancha
 * Date: 26/01/2015
 * Time: 09:33
 */
public class Heap {
    private IntNodeCh12[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx){
        maxSize = mx;
        currentSize = 0;
        heapArray = new IntNodeCh12[maxSize];
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        IntNodeCh12 bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public void trickleDown(int index) {
        int largerChild;
        IntNodeCh12 top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;

            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }

            if (top.getKey() >= heapArray[largerChild].getKey()) {
                break;
            }

            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }

    public boolean insert(int key){
        if(currentSize == maxSize){
            return false;
        }

        IntNodeCh12 newNode = new IntNodeCh12(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public IntNodeCh12 remove() {
        IntNodeCh12 root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }

        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        if (oldValue < newValue) {
            trickleUp(index);
        } else {
            trickleDown(index);
        }

        return true;
    }

    public void displayHeap(){
        System.out.print("Heap Array: ");
        for (int m = 0; m < currentSize; m++) {
            if (heapArray[m] != null) {
                System.out.print(heapArray[m].getKey()+" ");
            } else {
                System.out.print("-- ");
            }
        }
        System.out.println();

//        //        Deque<NodeCh08<T>> globalStack = new ArrayDeque<>();
//        LinkedList<IntNodeCh12> globalStack = new LinkedList<>();
//        LinkedList<IntNodeCh12> spacesStack = new LinkedList<>();
//        int index = 0;
//        globalStack.push(heapArray[index]);
//        int step = 1;
////        spacesStack.push(_root);
//        int nBlanks = 32;
//        boolean isRowEmpty = false;
//        System.out.println(".............................................................................................................................................................");
//        while(isRowEmpty == false){
////            Deque<NodeCh08<T>> localStack = new ArrayDeque<>();
//            LinkedList<IntNodeCh12> localStack = new LinkedList<>();
//            isRowEmpty = true;
//
//            for (int j = 0; j < nBlanks; j++) {
//                System.out.print("  ");
//            }
//
//            while (spacesStack.isEmpty() == false) {
//                IntNodeCh12 temp = spacesStack.pop();
//
//                if(temp != null) {
//                    for (int j = 0; j < nBlanks; j++) {
//                        System.out.print("__");
//                    }
//                    if (spacesStack.size() % 2 != 0) {
//                        System.out.print("|");
//                    }
//                } else {
//                    for (int j = 0; j < nBlanks; j++) {
//                        System.out.print("  ");
//                    }
//
//                    if (spacesStack.size() % 2 != 0 && spacesStack.peek() != null) {
//                        System.out.print("|");
//                    }
//                }
//
//                if (spacesStack.size() % 2 == 0) {
//                    for (int j = 0; j < nBlanks * 2; j++) {
//                        System.out.print("  ");
//                    }
//                }
//            }
//            System.out.println();
//
//            for (int j = 0; j < nBlanks; j++) {
//                System.out.print("  ");
//            }
//
//            while (globalStack.isEmpty() == false) {
//                IntNodeCh12 temp = globalStack.pop();
//                if(temp != null){
//                    System.out.print(temp.getKey());
//
//                    int leftChild = 2 * index + step;
//                    int rightChild = leftChild + step;
//
//                    localStack.push(heapArray[leftChild]);
//                    localStack.push(heapArray[rightChild]);
//
//                    if(heapArray[leftChild] != null || heapArray[rightChild] != null){
//                        isRowEmpty = false;
//                    }
//                } else {
////                    System.out.print("--");
//                    System.out.print("  ");
//                    localStack.push(null);
//                    localStack.push(null);
//                }
//
//                for (int j = 0; j < nBlanks * 2 - 1; j++) {
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//            nBlanks /= 2;
//            step*=2;
//            index++;
//            while (localStack.isEmpty() == false) {
//                IntNodeCh12 temp = localStack.pop();
//                globalStack.push(temp);
//                spacesStack.push(temp);
//            }
//
//        }
//        System.out.println(".............................................................................................................................................................");

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = ".............................................................................................................................................................";
        System.out.println(dots);

        while (currentSize > 0) {

            if (column == 0) {
                for (int k = 0; k < nBlanks; k++) {
                    System.out.print(" ");
                }
            }

            System.out.print(heapArray[j].getKey());

            if(++j == currentSize) {
                break;
            }

            if(++column == itemsPerRow) {
                System.out.println();
//                for (int l = column; l > 0; l--) {
//                    for (int k = 0; k < nBlanks; k++) {
//                        System.out.print(" ");
//                    }
//                    System.out.print("|");
//                }
//                System.out.println();

                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;

            } else {
                for (int k = 0; k < nBlanks * 2 - 1; k++) {
                    System.out.print(" ");
                }

//                //                if (column == 0) {
//                for (int k = 0; k < nBlanks; k++) {
//                    System.out.print(" ");
//                }
//                System.out.println("|");
////                }
            }


        }
        System.out.println("\n" + dots);



//        int nBlanks = 32;
//        int itemsPerRow = 1;
//        int column = 0;
//        int j = 0;
//        String dots = ".............................................................................................................................................................";
//        System.out.println(dots);
//        LinkedList<Integer> row = new LinkedList<>();
//        LinkedList<Integer> space = new LinkedList<>();
//
//        for (int index = 0; index < currentSize; index++) {
//
//            if (column == 0) {
//                for (int k = 0; k < nBlanks; k++) {
//                    System.out.print(" ");
//                }
//            }
//
//            int value = heapArray[index].getKey();
//            System.out.print(value);
//
//            row.add(value);
//            space.add(value);
//
//            if (++column == itemsPerRow) {
//                System.out.println("("+row.size()+")");
//                for (int k = 0; k < nBlanks / 2; k++) {
//                    System.out.print(" ");
//                }
//                while(!row.isEmpty()) {
//                    row.pop();
//                    for (int k = 0; /*!row.isEmpty() && */ k < nBlanks / 2; k++) {
//                        System.out.print("_");
//                    }
//                    System.out.print("|");
//
//                    for (int k = 0; /*!row.isEmpty() &&*/ k < nBlanks / 2; k++) {
//                        System.out.print("_");
//                    }
//
//                }
//
//                nBlanks /= 2;
//                itemsPerRow *= 2;
//                column = 0;
//                System.out.println();
//            } else {
//                for (int k = 0; k < nBlanks * 2 - 2; k++) {
//                    System.out.print(" ");
////                    System.out.print("_");
//                }
//            }
//        }
//
//        System.out.println("\n" + dots);
    }
}
