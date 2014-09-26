package everything.ThreadShootingRange;

import everything.ThreadShootingRange.data.ThreadNameResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

/**
 * User: Makar Kalancha
 * Date: 02/05/14
 * Time: 2:54 PM
 */
public class WorkerCallable implements Callable<ThreadNameResult>{
    private final int flag;
    public WorkerCallable(int flag) {
        this.flag = flag;
    }

    @Override
    public ThreadNameResult call() {
        ThreadNameResult threadNameResult = new ThreadNameResult();
        Integer randomNumber = 0;
        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd kk:mm:ss.S");
        try {
            System.out.println("Callable [" + sdf.format(new Date()) + "] " + Thread.currentThread().getName() + "-" + flag + ": start");
            Thread.sleep(3000);
            System.out.println("Callable [" + sdf.format(new Date()) + "] " + Thread.currentThread().getName() + "-" + flag + ": end");
            randomNumber = tlr.nextInt(0, 10);
            threadNameResult.randomNumber = randomNumber;
            threadNameResult.threadName = Thread.currentThread().getName() + "-" + flag;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return threadNameResult;
    }


}
