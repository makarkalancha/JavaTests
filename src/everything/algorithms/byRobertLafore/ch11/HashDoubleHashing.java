package everything.algorithms.byRobertLafore.ch11;

/**
 * User: Makar Kalancha
 * Date: 20/01/2015
 * Time: 15:55
 */
public class HashDoubleHashing<T extends Comparable>{

    private DataItemCh11<T>[] hashArray;
    private int arraySize;
    private DataItemCh11Null<T> nonItem;

    public HashDoubleHashing(int size) {
        this.arraySize = size;
        hashArray = new DataItemCh11[this.arraySize];
        nonItem = new DataItemCh11Null<T>();
    }

    public void displayTable(){
        System.out.print("Table: ");
        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null) {
                System.out.print(hashArray[j].getKey()+" ");
            } else {
                System.out.print("** ");
            }
        }
        System.out.println();
    }

    public int hashFunc1(T key) {
        return key.hashCode() % arraySize;
    }

    public int hashFunc2(T key) {
        return 5 - key.hashCode() % 5;
    }

    public void insert(DataItemCh11<T> item){
        T key = item.getKey();
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while(hashArray[hashVal] != null && !hashArray[hashVal].isNull()) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItemCh11<T> delete(T key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null){
            if(hashArray[hashVal].getKey().equals(key)) {
                DataItemCh11<T> temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }

            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public DataItemCh11<T> find(T key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null){
            if(!hashArray[hashVal].isNull() && hashArray[hashVal].getKey().equals(key)) {
                return hashArray[hashVal];
            }

            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    private boolean isPrime(int n) {
        for (int j = 2; (j * j <= n); j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }

    private int getPrime(int min) {
        for (int j = min + 1; true; j++) {
            if (isPrime(j)) {
                return j;
            }
        }
    }
}
