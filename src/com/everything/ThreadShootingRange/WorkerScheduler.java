package com.everything.ThreadShootingRange;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * User: Makar Kalancha
 * Date: 02/05/14
 * Time: 2:27 PM
 */
public class WorkerScheduler extends ScheduledThreadPoolExecutor {
    private final int _poolSize;
    private final ThreadFactory _factory;
    public WorkerScheduler(int poolSize,ThreadFactory factory) {
        super(poolSize, factory);
        this._poolSize = poolSize;
        this._factory = factory;
    }

//    public static ScheduledExecutorService createPool(int poolSize,ThreadFactory factory) {
//        WorkerScheduler ws = new WorkerScheduler(poolSize, factory);
//        return  Executors.newScheduledThreadPool(_poolSize, _factory);
//    }

    @Override
    public void shutdown() {
        try{
            super.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        }catch(InterruptedException e){
            System.out.println("terminated before");
            e.printStackTrace();
        }
    }
}
