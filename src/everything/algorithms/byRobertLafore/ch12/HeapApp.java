package everything.algorithms.byRobertLafore.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: Makar Kalancha
 * Date: 26/01/2015
 * Time: 10:02
 */
public class HeapApp {
    public static void main(String[] args) throws IOException{
        int value1;
        int value2;
        Heap theHeap = new Heap(31);
        boolean success;

        theHeap.insert(70);
        theHeap.insert(40);
        theHeap.insert(50);
        theHeap.insert(20);
        theHeap.insert(60);
        theHeap.insert(100);
        theHeap.insert(80);
        theHeap.insert(30);
        theHeap.insert(10);
        theHeap.insert(90);

//        theHeap.displayHeap();

        boolean isRunning = true;

        while(isRunning){
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, remove, quit, or change: ");
            char choice = getChar();
            switch (choice){
                case 's':
                    theHeap.displayHeap();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    value1 = getInt();
                    success = theHeap.insert(value1);
                    if(!success){
                        System.out.println("Can't insert; heap full");
                    }
                    break;
                case 'r':
                    if (!theHeap.isEmpty()) {
                        theHeap.remove();
                    } else {
                        System.out.println("Can't remove; heap empty");
                    }
                    break;
                case 'c':
                    System.out.print("Enter current index of item: ");
                    value1 = getInt();
                    System.out.print("Enter new key: ");
                    value2 = getInt();
                    success = theHeap.change(value1, value2);
                    if(!success) {
                        System.out.println("Invalid index");
                    }
                    break;
                case 'q':
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid entry");
                    break;
            }
        }
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
