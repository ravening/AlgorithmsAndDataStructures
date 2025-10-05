package main.java.multithreading;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinExample {
    public static void main(String[] args) {
        AppleTree[] appleTrees = AppleTree.newTreeGarden(6);

        Callable<Void> applePicker1 = createApplePicker(appleTrees, 0, 2, "Alex");
        Callable<Void> applePicker2 = createApplePicker(appleTrees, 2, 4, "Bob");
        Callable<Void> applePicker3 = createApplePicker(appleTrees, 4, 6, "Carol");

        ForkJoinPool.commonPool().invokeAll(List.of(applePicker1, applePicker2, applePicker3));

        System.out.println();
        System.out.println("All fruits collected!");
    }

    public static Callable<Void> createApplePicker(AppleTree[] appleTrees, int fromIndexInclusive, int toIndexExclusive,
                                                   String workerName) {
        return () -> {
            IntStream.range(fromIndexInclusive, toIndexExclusive)
                    .forEach(i -> appleTrees[i].pickApples(workerName));
            return null;
        };
    }
}
