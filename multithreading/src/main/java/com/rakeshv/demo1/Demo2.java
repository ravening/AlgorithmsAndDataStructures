package com.rakeshv.demo1;

public class Demo2 {
    public static void main(String[] args) {
        UsingRunnable runnable = new UsingRunnable();
        runnable.run();
    }
}

class UsingRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("From thread " + Thread.currentThread().getName());
    }
}
