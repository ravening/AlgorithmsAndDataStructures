package com.rakeshv;

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

        Long finalValue = Optional.ofNullable(value)
                .map(x -> 10L)
                .orElseGet(() -> 5L);

//        System.out.println(finalValue);
        Lambdas lambdas = new Lambdas();
        String result = Optional.ofNullable(value)
                .map(x -> lambdas.doThisIfNotNull())
                .orElseGet(lambdas::doThisIfNull);
        System.out.println(result);
    }

    public String doThisIfNotNull() {
        return ("i accept only non null values");
    }

    public String doThisIfNull() {
        return ("i accept ONLY null values");
    }
}
