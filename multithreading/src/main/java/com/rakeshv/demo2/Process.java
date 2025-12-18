package com.rakeshv.demo2;

import java.util.Scanner;

public class Process {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();

        System.out.println("Press enter to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        processor.shutdown();
    }
}

class Processor extends Thread {
    private volatile boolean running = true;
    @Override
    public void run() {
        while (running) {
            System.out.println("From thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }

    protected void shutdown() {
        this.running = false;
    }
}
