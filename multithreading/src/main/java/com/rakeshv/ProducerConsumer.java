package com.rakeshv;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
    private final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(producerConsumer.consumer);
        executorService.submit(producerConsumer.producer);


    }

    private void producer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            int next = random.nextInt(1000);
            System.out.println("Produced " + next + " by thread " + Thread.currentThread().getName());
            blockingQueue.put(next);
        }
    }

    private void consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            Integer next = blockingQueue.take();
            System.out.println("Consumer consumed " + next + " by thread " + Thread.currentThread().getName());
        }
    }

    Runnable producer = () -> {
        try {
            producer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

    Runnable consumer = () -> {
        try {
            consumer();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    };

}
