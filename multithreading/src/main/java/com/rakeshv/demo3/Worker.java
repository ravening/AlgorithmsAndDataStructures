package com.rakeshv.demo3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Worker {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Processor(i));
        }

        executorService.shutdown();

    }
}

class Processor implements Runnable {
    private int count;

    Processor(int x) {
        this.count = x;
    }

    @Override
    public void run() {
        System.out.println("Starting count is " + count);

        try {
            Thread.sleep(3000);
        } catch (Exception e) {}
        System.out.println("Ending count is " + count);
    }
}
