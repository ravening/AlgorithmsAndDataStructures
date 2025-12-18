package com.rakeshv.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class Demo1 {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();

        Callable<String> callable = () -> {
            return Thread.currentThread().getName();
        };

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> result = service.submit(callable);

        System.out.println("done in main");
        while (!result.isDone()) {
            try {
                System.out.println(result.get());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        service.shutdown();

        Supplier<String> supplier = () -> "from supplier";
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    
}

class Runner extends Thread {
    @Override
    public void run() {
        System.out.println("From thread " + Thread.currentThread().getName());
    }
}
