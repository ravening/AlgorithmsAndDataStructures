package com.rakeshv.demo3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountdownLatches {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Latch(countDownLatch));
        }

        countDownLatch.await();
        System.out.println("Latch completed");
        executorService.shutdown();
    }
}

class Latch implements Runnable {
    private CountDownLatch countDownLatch;

    Latch(CountDownLatch latch) {
        this.countDownLatch = latch;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("inside the thread");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        countDownLatch.countDown();
    }
}
