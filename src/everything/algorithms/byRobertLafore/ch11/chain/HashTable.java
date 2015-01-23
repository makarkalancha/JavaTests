package everything.algorithms.byRobertLafore.ch11.chain;

/**
 * User: Makar Kalancha
 * Date: 23/01/2015
 * Time: 16:24
 */
public class HashTable<T extends Comparable> {
    private SortedList<T>[] hashArray;
    private int arraySize;

    public HashTable(int size){
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int j = 0; j < arraySize; j++) {
            hashArray[j] = new SortedList<>();
        }
    }

    public void displayTable() {
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j + ". ");
            hashArray[j].displayList();
        }
    }

    public int hashFunc(T key) {
        return key.hashCode() % arraySize;
    }

    public void insert(Link<T> theLink) {
        T key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    public void delete(T key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link<T> find(T key) {
        int hashVal = hashFunc(key);
        Link<T> theLink = hashArray[hashVal].find(key);
        return theLink;
    }
}
