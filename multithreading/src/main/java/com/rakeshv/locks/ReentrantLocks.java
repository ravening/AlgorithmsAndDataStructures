package com.rakeshv.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {
    int value = 0;
    ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ReentrantLocks locks = new ReentrantLocks();

        executor.submit(locks.runnable);
        executor.submit(locks.runnable);
        executor.submit(locks.runnable);

        executor.shutdown();

    }

    public void increment() {
        try {
            lock.lock();
            value++;
            System.out.println("Count is " + value);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    Runnable runnable = () -> {
        increment();
    };
}
