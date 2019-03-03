package com.everything.algorithms.byRobertLafore.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: Makar Kalancha
 * Date: 27/01/2015
 * Time: 10:33
 */
public class HeapSortedApp {
    public static void main(String[] args) throws IOException{
        int size;
        int j;

        System.out.print("Enter number of items: ");
        size = getInt();

        HeapSorted theHeap = new HeapSorted(size);

        for (j = 0; j < size; j++) {
            int random = (int) (Math.random() * 100);
            IntNodeCh12 newNode = new IntNodeCh12(random);
            theHeap.insertAt(j, newNode);
            theHeap.incrementSize();
        }

        System.out.print("Random: ");
        theHeap.displayArray();
        theHeap.displayHeap();

        for (j = size / 2 - 1; j >= 0; j--) {
            theHeap.trickleDown(j);
        }

        System.out.print("Heap: ");
        theHeap.displayArray();
        theHeap.displayHeap();

        HeapSorted theHeap1 = new HeapSorted(size);
        for (j = size - 1; j >= 0; j--) {
            IntNodeCh12 biggestNode = theHeap.remove();
            theHeap1.insertAt(j, biggestNode);
            theHeap1.incrementSize();
        }

        System.out.print("Sorted: ");
        theHeap1.displayArray();

    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
