package com.everything.ThreadShootingRange;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: Makar Kalancha
 * Date: 02/05/14
 * Time: 2:54 PM
 */
public class WorkerRunnable implements Runnable{
    private final int flag;
    public WorkerRunnable(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd kk:mm:ss.S");
        try {
            System.out.println("Runnable ["+sdf.format(new Date())+"] "+Thread.currentThread().getName() + "-"+flag+": start");
            Thread.sleep(3000);
            System.out.println("Runnable ["+sdf.format(new Date())+"] "+Thread.currentThread().getName() + "-"+flag+": end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
