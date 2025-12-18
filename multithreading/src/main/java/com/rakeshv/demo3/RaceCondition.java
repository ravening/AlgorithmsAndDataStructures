package com.rakeshv.demo3;

public class RaceCondition {
    int count = 0;
    public static void main(String[] args) throws InterruptedException {

        RaceCondition raceCondition = new RaceCondition();
        raceCondition.doWork();

        System.out.println(raceCondition.getCount());
    }

    private void doWork() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i< 10000; i++) {
                    increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i< 10000; i++) {
                    increment();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
