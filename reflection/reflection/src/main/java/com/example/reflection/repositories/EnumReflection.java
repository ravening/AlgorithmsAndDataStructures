package com.example.reflection.repositories;

import java.util.HashMap;
import java.util.Map;

public class EnumReflection {
    public static void main(String[] args) {
        // List fields = Arrays.stream(Currency.class.getDeclaredFields())
        // .filter(x -> !x.isEnumConstant() && !x.isSynthetic())
        // .map(x -> x.getType())
        // .collect(Collectors.toList());

        // fields.forEach(System.out::println);
        Map<String, Currency> enumMap = new HashMap<>();
        for (var value : Currency.values()) {
            enumMap.put(value.toString().toLowerCase(), value);
        }

        System.out.println(enumMap.getOrDefault("usd", null));

    }
}

enum Currency {
    USD,
    INR,
    EUR,
    GBP;

    Currency() {
    }
}