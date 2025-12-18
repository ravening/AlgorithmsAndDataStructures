package com.rakeshv.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Runnable runnable = () -> {
            System.out.println("Executing from thread " +
             Thread.currentThread().getName());
        };

        CompletableFuture completableFuture =
            CompletableFuture.runAsync(runnable, executorService);
        
        System.out.println("From main");
        completableFuture.join();

        Supplier<String> supplier = () -> "From " + Thread.currentThread().getName();

        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(supplier, executorService);
        String result = completableFuture1.join();
        System.err.print(result);

        Supplier<String> delayedSupplier = () -> {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {}

            return "sleep complete";
        };

        CompletableFuture<String> longFuture = CompletableFuture.supplyAsync(delayedSupplier, executorService);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        System.err.print("He is taking long time to complete");
        longFuture.complete("He's dead jim");
        executorService.shutdown();
    }
}