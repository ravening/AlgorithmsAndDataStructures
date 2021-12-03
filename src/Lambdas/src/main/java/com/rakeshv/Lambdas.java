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
public class Lambdas
{
    public static void main( String[] args )
    {
        Supplier<String> supplier = () -> "Hello world from supplier";
         System.out.println(supplier.get());

        Consumer<String> consumer = System.out::println;
         consumer.accept("Hello world from consumer");

        List<String> strings = new ArrayList<>(List.of("one", "two", "three", "four", "five"));
        strings.removeIf(string -> string.startsWith("t"));
         strings.forEach(consumer);

        src.Lambdas.src.main.java.com.rakeshv.User sarah = new src.Lambdas.src.main.java.com.rakeshv.User("sarah", 28);
        src.Lambdas.src.main.java.com.rakeshv.User james = new src.Lambdas.src.main.java.com.rakeshv.User("james", 35);
        src.Lambdas.src.main.java.com.rakeshv.User mary = new src.Lambdas.src.main.java.com.rakeshv.User("mary", 33);
        src.Lambdas.src.main.java.com.rakeshv.User john2 = new src.Lambdas.src.main.java.com.rakeshv.User("john2", 24);
        src.Lambdas.src.main.java.com.rakeshv.User john1 = new src.Lambdas.src.main.java.com.rakeshv.User("john1", 26);

        List<src.Lambdas.src.main.java.com.rakeshv.User> users = new ArrayList<>(List.of(sarah, james, mary, john1, john2));
        users.stream().map(src.Lambdas.src.main.java.com.rakeshv.User::getName).forEach(consumer);

        IntSupplier intSupplier = () -> 10;
        int value = intSupplier.getAsInt();
        System.out.println(value);

        DoubleToIntFunction doubleToIntFunction = number -> (int) Math.floor(number);
        value = doubleToIntFunction.applyAsInt(19.99);
        System.out.println(value);

        int pi = doubleToIntFunction.applyAsInt(Math.PI);
        System.out.println(pi);

        // Compare using name
        Comparator<src.Lambdas.src.main.java.com.rakeshv.User> comparator = Comparator.comparing(src.Lambdas.src.main.java.com.rakeshv.User::getName);
        // compare using age
        Comparator<src.Lambdas.src.main.java.com.rakeshv.User> ageComparator = Comparator.comparing(src.Lambdas.src.main.java.com.rakeshv.User::getAge);
        // reverse
        Comparator<src.Lambdas.src.main.java.com.rakeshv.User> reverseComparator = comparator.reversed();
        Consumer<src.Lambdas.src.main.java.com.rakeshv.User> userConsumer = System.out::println;
        comparator.thenComparing(ageComparator);
        users.sort(comparator);
        // users.forEach(userConsumer);

        System.out.println("========");
        users.sort(reverseComparator);
        users.forEach(userConsumer);
    }
}
