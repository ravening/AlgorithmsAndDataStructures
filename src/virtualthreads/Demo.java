package virtualthreads;

import java.util.concurrent.Executors;

public class Demo {

    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                    System.out.println("Hello");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });


        }
    }
}
