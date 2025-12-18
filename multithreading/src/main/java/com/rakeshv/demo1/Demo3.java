package com.rakeshv.demo1;

public class Demo3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("From runnable " + Thread.currentThread().getName());
            }
        });

        t1.start();

        Thread t2 = new Thread(new ImplementRunnable());
        t2.start();
    }
}

class ImplementRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("From runnable " + Thread.currentThread().getName());
    }
}
