package everything.algorithms.byRobertLafore.ch14;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * User: Makar Kalancha
 * Date: 29/01/2015
 * Time: 09:57
 */
public class PriorityQueueEdge implements Iterable<EdgeCh14>{
    private PriorityQueue<EdgeCh14> que;

    public PriorityQueueEdge() {
        que = new PriorityQueue<>();
    }

    public void insert(EdgeCh14 item) {
        que.add(item);
    }

    @Override
    public Iterator<EdgeCh14> iterator() {
        return que.iterator();
    }

    public EdgeCh14 removeMin() {
        return que.poll();
    }

    public boolean isEmpty() {
        return que.isEmpty();
    }

    public void removeN(EdgeCh14 item) {
        que.remove(item);
    }

    public EdgeCh14 peekMin() {
        return que.peek();
    }

//    public T peekN() {
//        return que.peek();
//    }

    public int size() {
        return que.size();
    }

    public EdgeCh14 findByDestanation(int destanationToFind) {
        Iterator<EdgeCh14> iterator = que.iterator();
        while(iterator.hasNext()) {
            EdgeCh14 edgeCh14 = iterator.next();
            if (edgeCh14.destVert == destanationToFind) {
                return edgeCh14;
            }
        }

        return null;
    }
}
