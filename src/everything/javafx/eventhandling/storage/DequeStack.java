package everything.javafx.eventhandling.storage;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * User: Makar Kalancha
 * Date: 11/04/2016
 * Time: 23:41
 */
//http://baddotrobot.com/blog/2013/01/10/stack-vs-deque/
public class DequeStack<T> implements Stack<T> {
    private int sizeLimit = 0;
    private int currentSize = 0;
    private Deque<T> deque = new ArrayDeque<>();

    public DequeStack(){

    }

    public DequeStack(int sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    private boolean isLimitGTZero() {
        return sizeLimit > 0;
    }

    @Override
    public void push(T t) {
        System.out.println("push->sizeLimit:" + sizeLimit + "; currentSize:" + currentSize + "; size:" + deque.size());
        if (isLimitGTZero() && sizeLimit <= currentSize) {
            deque.removeLast();
        } else {
            ++currentSize;
        }
        deque.addFirst(t);
    }

    @Override
    public T pop() {
        System.out.println("pop->sizeLimit:" + sizeLimit + "; currentSize:" + currentSize + "; size:" + deque.size());
        --currentSize;
        return deque.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void clear() {
        System.out.println("pop->sizeLimit:" + sizeLimit + "; currentSize:" + currentSize + "; size:" + deque.size());
        currentSize = 0;
        deque.clear();
    }

    @Override
    public String toString() {
        return deque.toString();
    }

}
