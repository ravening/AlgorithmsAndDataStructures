package com.rakeshv.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocksDemo {
    private Map<String, String> map;
    ReadWriteLock readWriteLocks = new ReentrantReadWriteLock(true);

    ReadWriteLocksDemo() {
        map = new HashMap<String, String>();
    }
    public static void main(String[] args) {
        ReadWriteLocksDemo readWriteLocksDemo = new ReadWriteLocksDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(readWriteLocksDemo.write);
        executorService.submit(readWriteLocksDemo.read);
        executorService.submit(readWriteLocksDemo.read);

        executorService.shutdown();
    }

    public void write() {
        try {
            readWriteLocks.writeLock().lock();
            map.put("foo", "bar");
            System.out.println("Sleeping after writing");
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        finally {
            readWriteLocks.writeLock().unlock();
        }
    }

    public void read() {
        try {
            Thread.sleep(1000);
            readWriteLocks.readLock().lock();
            System.out.println("Value of foo is " + map.get("foo"));
        } catch (InterruptedException e) {
        } finally {
            readWriteLocks.readLock().unlock();
        }
    }

    Runnable read = () -> {
        read();
    };

    Runnable write = () -> {
        write();
    };
}
