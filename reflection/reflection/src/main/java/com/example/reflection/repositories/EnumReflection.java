package com.example.reflection.repositories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class EnumReflection {
    public static void main(String[] args) {
        // List fields = Arrays.stream(Currency.class.getDeclaredFields())
        //                             .filter(x -> !x.isEnumConstant() && !x.isSynthetic())
        //                             .map(x -> x.getType())
        //                             .collect(Collectors.toList());

        // fields.forEach(System.out::println);
        Map<String, Currency> enumMap = new HashMap<>();
       for (var value : Currency.values()) {
            enumMap.put(value.toString().toLowerCase(), value);
       }

       System.out.println(enumMap.getOrDefault("usd", null));

    }
}

enum Currency {
    USD("dollar", 1, "USA"),
    INR("ruppe", 2, "India"),
    EUR("euro", 3, "Europe"),
    GBP("pound", 4, "UK")
    ;

    private final String name;
    private final int unit;
    private final String country;

    Currency(String name, int unit, String country) {
        this.name = name;
        this.unit = unit;
        this.country = country;
    }

    private String getName() {
        return name;
    }
}