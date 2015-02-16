package everything.java8tests.ch02.exercises;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: Makar Kalancha
 * Date: 16/02/2015
 * Time: 17:06
 */
public class Num001Counter implements Runnable{
    private int start;
    private int end;
    private List<String> words;
    private AtomicInteger count;
    public Num001Counter(List<String> words, int offset, int limit, AtomicInteger count) {
        this.words = words;
        this.start = offset*limit;
        this.count = count;
        this.end = start + limit-1;
        end = (end > words.size()) ? words.size() - 1 : end;
    }

    @Override
    public void run() {
//        System.out.println("start:" + start+"; end:"+end);
        for (int i = start; i <= end; i++) {
            if (words.get(i).length() < 12) {
//                System.out.println(i + ":" + count.addAndGet(1));
                count.addAndGet(1);
            }
        }
    }
}
