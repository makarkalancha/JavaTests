/*
 * Software property of Acquisio. Copyright 2003-2019.
 */
package com.everything.threads.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author Macar Calancea (mcalancea@acquisio.com)
 */
// The work could be a Cook, Helper, or Attendant. Though the three work independently, the
// should all synchronize their work together to do their part and complete preparing a food item
class Worker extends Thread {
    Phaser deliveryOrder;

    Worker(Phaser order, String name, long sleepSec) throws InterruptedException{
        deliveryOrder = order;
        this.setName(name);
        deliveryOrder.register();
        System.out.println(name + ": " + sleepSec);
        sleep(TimeUnit.SECONDS.toMillis(sleepSec));
        start();
    }

    public void run() {
        for(int i = 1; i <= 3; i++) {
            System.out.println("\t" + getName() + " doing his work for order no. " + i);
            if(i == 3) {
// work completed for this delivery order, so deregister
                deliveryOrder.arriveAndDeregister();
            } else {
                deliveryOrder.arriveAndAwaitAdvance();
            }
            try {
                Thread.sleep(3000); // simulate time for preparing the food item
            } catch(InterruptedException ie) {
                /* ignore exception */
                ie.printStackTrace();
            }
        }
    }
}
