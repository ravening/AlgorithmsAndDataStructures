package com.rakeshv;

import java.util.function.Function;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        Function<String, String> header = (s -> "From Mario and Raul:\n" + s);
        Function<String, String> spellCheck = (s -> s.replaceAll("labda", "lambda"));
        Function<String, String> footer = (s -> s + "\nThanks in advance");

        Function<String, String> pipeline = header.andThen(spellCheck).andThen(footer);
        String result = pipeline.apply("Arent labdas very helpful?");
        System.out.println(result);
    }
}
