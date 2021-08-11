package com.rakeshv.completablefutures;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class OrderingPizza {

    public static void main(String[] args) {
        OrderingPizza pizza = new OrderingPizza();

        // get list of bases
        CompletableFuture<List<Pizza>> pizzaBases = pizza.getPizzaBases();

        pizzaBases.thenRun(() -> System.out.println("Collected all pizza bases"));

        // get ids of pizza
        CompletableFuture<List<Integer>> pizzaIds = pizzaBases.thenApplyAsync(
            p -> p.stream().map(Pizza::getId).collect(Collectors.toList()));

        pizzaIds.thenAccept(pid -> System.out.println("Pizza ids are " + pid));
    }

    public CompletableFuture<List<Pizza>> getPizzaBases() {
        List<Pizza> pizzas = Collections.
                    unmodifiableList(List.of(new Pizza(1, "Plain"), new Pizza(2,"Cajun"),
                    new Pizza(3, "Crunchy"), new Pizza(4,"Cheeseburst"),
                    new Pizza(5,"Thin crust"), new Pizza(6, "Honeyoat")));
        return CompletableFuture.
            completedFuture(pizzas);
    }
}

/**
 * Pizza
 */
class Pizza {

    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pizza(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Pizza(){}

}
