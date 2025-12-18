package com.rakeshv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Hello world!
 *
 */
public class Lambdas {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello world from supplier";
        System.out.println(supplier.get());

        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello world from consumer");

        List<String> strings = new ArrayList<>(List.of("one", "two", "three", "four", "five"));
        strings.removeIf(string -> string.startsWith("t"));
        strings.forEach(consumer);

        User sarah = new User("sarah", 28);
        User james = new User("james", 35);
        User mary = new User("mary", 33);
        User john2 = new User("john2", 24);
        User john1 = new User("john1", 26);

        List<User> users = new ArrayList<>(List.of(sarah, james, mary, john1, john2));
        users.stream().map(User::getName).forEach(consumer);

        IntSupplier intSupplier = () -> 10;
        int value = intSupplier.getAsInt();
        System.out.println(value);

        DoubleToIntFunction doubleToIntFunction = number -> (int) Math.floor(number);
        value = doubleToIntFunction.applyAsInt(19.99);
        System.out.println(value);

        int pi = doubleToIntFunction.applyAsInt(Math.PI);
        System.out.println(pi);

        // Compare using name
        Comparator<User> comparator = Comparator.comparing(User::getName);
        // compare using age
        Comparator<User> ageComparator = Comparator.comparing(User::getAge);
        // reverse
        Comparator<User> reverseComparator = comparator.reversed();
        Consumer<User> userConsumer = System.out::println;
        comparator.thenComparing(ageComparator);
        users.sort(comparator);
        // users.forEach(userConsumer);

        System.out.println("========");
        users.sort(reverseComparator);
        users.forEach(userConsumer);
    }
}
