/*
 * Software property of Acquisio. Copyright 2003-2019.
 */
package com.everything.threads.phaser;

import java.util.concurrent.Phaser;

/**
 * @author Macar Calancea (mcalancea@acquisio.com)
 */
// ProcessOrder thread is the master thread overlooking to make sure that the Cook, Helper,
// and Attendant are doing their part of the work to complete preparing the food items
// and complete order delivery
// To simplify the logic, we assume that each delivery order consists of exactly three food items
public class ProcessOrder {
    public static void main(String []args) throws InterruptedException {
        // the Phaser is the synchronizer to make food items one-by-one,
        // and deliver it before moving to the next item
        Phaser deliveryOrder = new Phaser(3);
        System.out.println("Starting to process the delivery order ");
        new Worker(deliveryOrder, "Cook", 5);
        new Worker(deliveryOrder, "Helper", 4);
        new Worker(deliveryOrder, "Attendant", 1);

        for(int i = 1; i <= 2; i++) {
// Prepare, mix and deliver this food item
            deliveryOrder.arriveAndAwaitAdvance();
            System.out.println("Deliver food oolean equalsitem no. " + i);
        }
// work completed for this delivery order, so deregister
        deliveryOrder.arriveAndDeregister();
        System.out.println("Delivery order completed... give it to the customer");
    }
}
