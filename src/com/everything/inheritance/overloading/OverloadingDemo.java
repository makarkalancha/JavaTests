package com.everything.inheritance.overloading;

/**
 * Created by mcalancea
 * Date: 12 Jul 2018
 * Time: 09:10
 */
public class OverloadingDemo {

    public static void main(String[] args) {
        TimeTask football = new Football();
        TimeTask hockey = new Hockey();

        Hockey hockey1 = new Hockey();

        Timer timer = new Timer();
        timer.schedule(football);
        timer.schedule(hockey);
        timer.schedule(hockey1);
    }

//    private static interface TimeTask{
//        public void run();
//    }

    private static abstract class TimeTask{
        public abstract void run();
    }

    private static class Football extends TimeTask{
        @Override
        public void run() {
            System.out.println("run football");
        }
    }

    private static class Hockey extends TimeTask {
        @Override
        public void run() {
            System.out.println("run hockey");
        }
    }

    private static class Timer{
        public void schedule(TimeTask timeTask){
            System.out.print("schedule general->");
            timeTask.run();
        }

        public void schedule(Football timeTask){
            System.out.print("schedule football->");
            timeTask.run();
        }

        public void schedule(Hockey timeTask){
            System.out.print("schedule hockey->");
            timeTask.run();
        }
    }
}
