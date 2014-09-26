package everything.ThreadShootingRange;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: Makar Kalancha
 * Date: 02/05/14
 * Time: 2:24 PM
 */
public class WorkerThreadFactory implements ThreadFactory {
    private String _name;
    private static AtomicInteger count = new AtomicInteger(1);
    public WorkerThreadFactory(String name) {
        this._name = name;

    }
    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable,_name+count.getAndIncrement());
        if(thread.isDaemon()){
            thread.setDaemon(false);
        }
        if(thread.getPriority() != Thread.NORM_PRIORITY) {
            thread.setPriority(Thread.NORM_PRIORITY);
        }
        return thread;
    }
}
