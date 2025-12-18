package com.rakeshv.locks;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ConditionsDemo {
    InnerStack stack;
    public static void main(String[] args) {
        InnerStack stack = new InnerStack();
        Producer producer = new Producer(stack);
        Consumer consumer = new Consumer(stack);

        consumer.start();
        producer.start();

    }

    static class InnerStack {
        private Stack<Object> stack;
        private int CAPACITY = 1;
        ReentrantLock lock;
        private Condition stackFullCondition;
        private Condition stackEmptyCondition;
        private boolean hasMoreItems;
        InnerStack() {
            stack = new Stack<Object>();
            lock = new ReentrantLock();
            stackFullCondition = lock.newCondition();
            stackEmptyCondition = lock.newCondition();
            hasMoreItems = true;
        }

        void push(Object o) {
            try {
                lock.lock();
                if (stack.size() >= CAPACITY) {
                    stackFullCondition.await();
                }
                stack.push(o);
                System.out.println("Added " + o + " to the stack");
                Thread.sleep(1000);
                stackEmptyCondition.signal();
            } catch (Exception e) {
                //TODO: handle exception
            } finally {
                lock.unlock();
            }
        }

        void pop() {
            try {
                lock.lock();
                if (stack.empty()) {
                    stackEmptyCondition.await();
                }
                System.out.println("Removed the element from the stack " + stack.pop());
                Thread.sleep(1000);
                stackFullCondition.signal();
            } catch (Exception e) {
                //TODO: handle exception
            } finally {
                lock.unlock();
            }
        }
    }

    static class Producer {
        private InnerStack stack;
        ExecutorService executor;
        
        Producer(InnerStack stack) {
            this.stack = stack;
            executor = Executors.newSingleThreadExecutor();
        }

        public void start() {
            executor.submit(runnable);
        }

        Runnable runnable = () -> {
            produce();
        };

        private void produce() {
            IntStream.range(0, 11).forEach(i -> {
                this.stack.push(i);
            });
            this.stack.hasMoreItems = false;
            this.executor.shutdown();
        }
    }

    static class Consumer {
        private InnerStack stack;
        ExecutorService executor;
        
        Consumer(InnerStack stack) {
            this.stack = stack;
            executor = Executors.newSingleThreadExecutor();
        }

        public void start() {
            executor.submit(runnable);
        }

        Runnable runnable = () -> {
            consume();
        };

        private void consume() {
            while (this.stack.hasMoreItems) {
                this.stack.pop();
            }
            this.executor.shutdown();
        }
    }
}
