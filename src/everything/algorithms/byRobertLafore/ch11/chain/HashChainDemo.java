package everything.algorithms.byRobertLafore.ch11.chain;

import everything.algorithms.byRobertLafore.ch11.DataItemCh11;
import everything.algorithms.byRobertLafore.ch11.HashOpenAddressing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: Makar Kalancha
 * Date: 23/01/2015
 * Time: 16:57
 */
public class HashChainDemo {
    public static void main(String[] args) throws IOException{
        int aKey;
        Link<Integer> aDataItem;
        int size;
        int n;
        int keysPerCell = 100;

        System.out.print("Enter size of hash table:");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        HashTable<Integer> hashTable = new HashTable<>(size);
//        HashDoubleHashing<Integer> hashTable = new HashDoubleHashing<>(size);

        for (int j = 0; j < n; j++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            aDataItem = new Link<>(aKey);
            hashTable.insert(aDataItem);
        }

        boolean isRunning = true;

        while(isRunning){
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, quit, or find: ");
            char choice = getChar();
            switch (choice){
                case 's':
                    hashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Link<>(aKey);
                    hashTable.insert(aDataItem);
                    hashTable.displayTable();
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    hashTable.delete(aKey);
                    hashTable.displayTable();
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = hashTable.find(aKey);
                    if(aDataItem != null){
                        System.out.println("Found "+aKey);
                    }else{
                        System.out.println("Could not find "+aKey);
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
