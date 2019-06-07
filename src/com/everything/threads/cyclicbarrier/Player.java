/*
 * Software property of Acquisio. Copyright 2003-2019.
 */
package com.everything.threads.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author Macar Calancea (mcalancea@acquisio.com)
 */
public class Player extends Thread {
    private CyclicBarrier waitPoint;

    public Player(CyclicBarrier barrier, String name, long sleepInSeconds) throws InterruptedException {
        this.setName(name);
        waitPoint = barrier;
        System.out.println("Player " + getName() + " is sleeping for " + sleepInSeconds);
        this.sleep(TimeUnit.SECONDS.toMillis(sleepInSeconds));
        this.start();
    }

    public void run() {
        System.out.println("Player " + getName() + " is ready ");
        try {
            waitPoint.await(); // await for all four players to arrive
        } catch(BrokenBarrierException | InterruptedException exception) {
            System.out.println("An exception occurred while waiting... " + exception);
        }
    }
}
