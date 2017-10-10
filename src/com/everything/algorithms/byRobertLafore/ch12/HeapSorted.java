package com.everything.algorithms.byRobertLafore.ch12;

/**
 * User: Makar Kalancha
 * Date: 27/01/2015
 * Time: 09:30
 */
public class HeapSorted {
    private IntNodeCh12[] heapArray;
    private int maxSize;
    private int currentSize;

    public HeapSorted(int mx) {
        maxSize = mx;
        currentSize = 0;
        heapArray = new IntNodeCh12[maxSize];
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

    public void insertAt(int index, IntNodeCh12 newNode){
        heapArray[index] = newNode;
    }

    public IntNodeCh12 remove() {
        IntNodeCh12 root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void incrementSize() {
        currentSize++;
    }

    public void displayHeap(){
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

                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;

            } else {
                for (int k = 0; k < nBlanks * 2 - 2; k++) {
                    System.out.print(" ");
                }

            }


        }
        System.out.println("\n" + dots);

    }

    public void displayArray(){
        System.out.print("Heap Array: ");
        for (int m = 0; m < currentSize; m++) {
            System.out.print(heapArray[m].getKey() + " ");
        }
        System.out.println();
    }
}


