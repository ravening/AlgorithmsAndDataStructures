package com.rakeshv.mythreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleExecutor {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future<Double> doubleFuture = getRandom();
        while (!doubleFuture.isDone()) {
            if (doubleFuture.isCancelled()) {
                System.out.println("Future is cancelled");
                break;
            }

            try {
                Thread.sleep(100);
            } catch (Exception e) {}
        }

        System.out.println(doubleFuture.get());
        executorService.shutdown();
    }

    public static Future<Double> getRandom() {
        return executorService.submit(() -> {
            Thread.sleep(1000);
            return Math.random();
        });
    }
}
