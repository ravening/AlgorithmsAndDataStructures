package com.rakeshv;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class Lambdas
{
    public static void main( String[] args )
    {
        Long value = null;

        List<Integer> integers = List.of(1, 3, 5, 7, 9, 100, 2, 4);

        Long finalValue = Optional.ofNullable(value)
                .map(x -> 10L)
                .orElseGet(() -> 5L);

//        System.out.println(finalValue);
        Lambdas lambdas = new Lambdas();
        String result = Optional.ofNullable(value)
                .map(x -> lambdas.doThisIfNotNull())
                .orElseGet(lambdas::doThisIfNull);
        System.out.println(result);
        System.out.println("current time is " + LocalDateTime.now());
        integers.parallelStream()
                .filter(Lambdas::isEven)
                .findAny()
                .ifPresent(System.out::println);
        System.out.println("new time is " + LocalDateTime.now());
    }

    public static boolean isEven(int x) {
        try {
            Thread.sleep(x * 100);
        } catch (Exception e) {}

        return x % 2 == 0;
    }
    public String doThisIfNotNull() {
        return ("i accept only non null values");
    }

    public String doThisIfNull() {
        return ("i accept ONLY null values");
    }
}
