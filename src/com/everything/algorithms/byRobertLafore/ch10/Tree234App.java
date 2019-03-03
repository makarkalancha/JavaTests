package com.everything.algorithms.byRobertLafore.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: Makar Kalancha
 * Date: 15/01/2015
 * Time: 13:51
 */
public class Tree234App {
    public static void main(String[] args) throws IOException {
        long value;
        Tree234<Long> theTree = new Tree234<>();
        theTree.insert(new Long(50));
        theTree.insert(new Long(40));
        theTree.insert(new Long(60));
        theTree.insert(new Long(30));
        theTree.insert(new Long(70));

        theTree.insert(new Long(100));
        theTree.insert(new Long(10));
        theTree.insert(new Long(150));
        theTree.insert(new Long(5));

        theTree.displayTree();

        boolean isRunning = true;
        while(isRunning){
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, find, quit: ");
            char choice = getChar();
            switch (choice){
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value);
                    break;
                case 'f':
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    int found = theTree.find(value);
                    if(found != -1){
                        System.out.println("Found "+value);
                    } else {
                        System.out.println("Could not find "+value);
                    }
                    break;
                case 'q':
                    isRunning = false;
                    System.out.println("quit");
                    break;
                default:
                    System.out.println("Invalid entry");
            }
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str = br.readLine();
        return str;
    }

    public static char getChar() throws IOException {
        String str = getString();
        return str.charAt(0);
    }

    public static int getInt() throws IOException {
        String str = getString();
        return Integer.parseInt(str);
    }
}
