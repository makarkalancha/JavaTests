/*
 * Software property of Acquisio. Copyright 2003-2019.
 */
package com.everything.threads.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author Macar Calancea (mcalancea@acquisio.com)
 */
// Creates a CyclicBarrier object by passing the number of threads and the thread to run
// when all the threads reach the barrier
public class CyclicBarrierTest {
    public static void main(String []args) throws Exception {
// a mixed-double tennis game requires four players; so wait for four players
// (i.e., four threads) to join to start the game
        System.out.println("Reserving tennis court \n As soon as four players arrive, game will start");
        CyclicBarrier barrier = new CyclicBarrier(4, new MixedDoubleTennisGame());
        new Player(barrier, "G I Joe", 2);
        new Player(barrier, "Dora", 4);
        new Player(barrier, "Tintin", 6);
        new Player(barrier, "Barbie", 1);
    }
}
