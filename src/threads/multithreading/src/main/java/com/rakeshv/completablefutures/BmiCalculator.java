package com.rakeshv.completablefutures;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class BmiCalculator {
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        BmiCalculator bmiCalculator = new BmiCalculator();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the weight");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter the height");
        double height = Double.parseDouble(scanner.nextLine());
        CompletableFuture<Double> getHeight = supplyAsync(() -> {
            if (height <= 0) {
                throw new IllegalArgumentException("Height cant be 0");
            }
            return height;
        },bmiCalculator.executorService).exceptionally(ex -> {
            System.out.println("Invalid height entered. so considering height as 1m");
            return 1.0;
        });

        CompletableFuture<Double> getWeight = supplyAsync(() -> {
            if (weight <= 0) {
                throw new IllegalArgumentException("Weight cant be 0");
            }
            return weight;
        }, bmiCalculator.executorService).exceptionally(ex -> {
            System.out.println("Invalid weight entered. so considering weight as 1kg");
            return 1.0;
        });

        System.out.println("Calculating BMI");
        TimeUnit.SECONDS.sleep(2);

        CompletableFuture<Double> bmiFuture = getHeight
                .thenCombineAsync(getWeight, (h, w) -> bmiCalculator.getBmi(w, h));

        System.out.println(bmiFuture.get());
        bmiCalculator.executorService.shutdownNow();
    }

    private double getBmi(double weight, double height) {
        return weight / (height * height);
    }

}
