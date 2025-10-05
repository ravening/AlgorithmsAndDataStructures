package main.java.multithreading;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AppleTree {
    private final String treeLabel;
    private final int numberOfApples;

    public static AppleTree[] newTreeGarden(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> new AppleTree("🌳#" + i))
                .toArray(AppleTree[]::new);
    }

    public AppleTree(String treeLabel) {
        this.treeLabel = treeLabel;
        numberOfApples = 3;
    }

    public int pickApples(String workerName) {
        try {
            //System.out.printf("%s started picking apples from %s \n", workerName, treeLabel);
            TimeUnit.SECONDS.sleep(1);
            System.out.printf("%s picked %d 🍏s from %s \n", workerName, numberOfApples, treeLabel);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return numberOfApples;
    }

    public int pickApples() {
        return pickApples(toLabel(Thread.currentThread().getName()));
    }

    private String toLabel(String threadName) {
        return Map.of(
                "ForkJoinPool.commonPool-worker-1", "Alice",
                "ForkJoinPool.commonPool-worker-2", "Bob",
                "ForkJoinPool.commonPool-worker-3", "Carol",
                "ForkJoinPool.commonPool-worker-4", "Dan"
        ).getOrDefault(threadName, threadName);
    }
}
