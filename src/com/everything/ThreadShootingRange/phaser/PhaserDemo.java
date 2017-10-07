package com.everything.ThreadShootingRange.phaser;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;

import java.util.concurrent.Phaser;

/**
 * Created by Makar Kalancha
 * Date: 19 Oct 2016
 * Time: 14:15
 */
public class PhaserDemo {
    public static void main(String[] args) {
        Phaser delivery = new Phaser(1);

        Worker<Void> worker1 = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                System.out.println("hello1");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){

                }
                return null;
            }
        };

        Worker<Void> worker2 = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                System.out.println("hello 2");
                return null;
            }
        };


    }
}
