package com.rakeshv.completablefutures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OrderSnacksForMovie {
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OrderSnacksForMovie orderSnacksForMovie = new OrderSnacksForMovie();
        CompletableFuture<String> getFood = orderSnacksForMovie.orderReady()
                .thenApplyAsync(result -> {
                    return "\nOrdering food completed";
                })
                .thenApplyAsync(nextstep -> {
                    return nextstep + "\nYou can proceed to movie theater";
                });

        System.out.println(getFood.get());
        orderSnacksForMovie.executorService.shutdown();
    }

    CompletableFuture<String> getPopCorn() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("worker: " + Thread.currentThread().getName() + " : Pop corn ready");
            return "Your pop corn is ready\n";
        }, executorService);
    }

    CompletableFuture<String> getDrinks() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker: " + Thread.currentThread().getName() + " : Drinks ready");
            return "Your drinks are ready\n";
        }, executorService);
    }

    CompletableFuture<String> getPayment() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("worker: " + Thread.currentThread().getName() + " Verifying payment");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker: " + Thread.currentThread().getName() + " : Payment successful");
            return "Payment success\n";
        }, executorService);
    }
    private String snacksReady(String message1, String message2) {
        return message1 + message2;
    }

    private CompletableFuture<String> orderReady() {
        return getPopCorn()
                .thenCombineAsync(getDrinks(), this::snacksReady)
                .thenComposeAsync(amount -> getPayment());
//                .thenCombineAsync(getPayment(), this::snacksReady);
    }

}
