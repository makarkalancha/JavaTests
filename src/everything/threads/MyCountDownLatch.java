package everything.threads;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Makar Kalancha
 * Date: 01 Nov 2016
 * Time: 09:58
 */
public class MyCountDownLatch {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch countDownLatch = new CountDownLatch(5);
        new Runner(countDownLatch, "Carl");
        new Runner(countDownLatch, "Joe");
        new Runner(countDownLatch, "Jack");

        System.out.println("Starting the countdown ");
        long countVal = countDownLatch.getCount();
        while (countVal > 0){
            Thread.sleep(1_000);
            System.out.println(countVal);
            if(countVal == 1){
                System.out.println("Start");
            }
            countDownLatch.countDown();
            countVal = countDownLatch.getCount();
        }
    }

    private static class Runner extends Thread{
        private CountDownLatch timer;

        public Runner(CountDownLatch cdl, String name){
            timer = cdl;
            this.setName(name);
            System.out.println(this.getName()+" ready and waiting for the count down to start");
            start();
        }

        @Override
        public void run() {
            try{
                timer.await();
            } catch (InterruptedException e){
                System.err.println("interrupted -- can't start running the race");
            }
            System.out.println(this.getName() + " started running");
        }
    }
}
