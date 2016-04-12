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
    private Deque<T> deque = new ArrayDeque<>();
    @Override
    public void push(T t) {
        deque.addFirst(t);
    }

    @Override
    public T pop() {
        return deque.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void clear() {
        deque.clear();
    }

}
