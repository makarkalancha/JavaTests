package everything.ThreadShootingRange;

import everything.ThreadShootingRange.data.ThreadNameResult;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * User: Makar Kalancha
 * Date: 02/05/14
 * Time: 2:52 PM
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        WorkerThreadFactory wtf = new WorkerThreadFactory("pool");
        Map<String, ScheduledFuture<ThreadNameResult>> map = new HashMap<>();
        LinkedBlockingQueue <ScheduledFuture<ThreadNameResult>> list = new LinkedBlockingQueue<>();
//        WorkerThreadFactory wtf2 = new WorkerThreadFactory("2");
//        WorkerThreadFactory wtf3 = new WorkerThreadFactory("3");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3,wtf);
        System.out.println("date and time:"+new Date());
        int qtyRows = 10;
        for(int i = 0 ; i < qtyRows;i++){
//            WorkerRunnable runnable = new WorkerRunnable(i);
//            scheduledExecutorService.schedule(runnable, 10, TimeUnit.SECONDS);
            WorkerCallable callable = new WorkerCallable(i);
//            ScheduledFuture<ThreadNameResult> scheduledFuture = scheduledExecutorService.schedule(callable, 2, TimeUnit.SECONDS);
//            ThreadNameResult tmp = scheduledFuture.get();
//            System.out.println("Result: thread name = "+tmp.threadName+"; randomNumber = "+tmp.randomNumber);
            list.put(scheduledExecutorService.schedule(callable, 2, TimeUnit.SECONDS));
        }

        for(ScheduledFuture<ThreadNameResult> threadNameResultScheduledFuture : list) {
            ThreadNameResult threadNameResult = threadNameResultScheduledFuture.get();
            System.out.println(threadNameResult.threadName+" : "+threadNameResult.randomNumber);
        }


        scheduledExecutorService.shutdown();
        System.out.println("out of for");
    }
}
