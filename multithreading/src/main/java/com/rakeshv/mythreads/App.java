package com.rakeshv.mythreads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        Count count = new Count();

        for (var i = 0; i < 10; i++) {
                Thread thread = new Thread(() -> {
                    try {
                        Count.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
        }
    }

}

class RunThread implements Runnable {

    @Override
    public void run() {
        IntStream.range(0, 10)
                .forEach(x -> {
                    System.out.println(x);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                });
    }
}

class Count {
    public static int counter = 0;
    public static Lock lock = new ReentrantLock();

    public static void increment() throws InterruptedException {
        if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
            try {
                int current = counter;
                System.out.println("Before: " + current + " thread id " + Thread.currentThread().getId());
                counter = current + 1;
                System.out.println("After: " + counter + " thread id " + Thread.currentThread().getId());
            } finally {
                lock.unlock();
            }
        }
    }
}
