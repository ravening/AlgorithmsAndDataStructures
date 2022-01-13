package com.rakeshv;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ChainingLambdas {
    public static void main(String[] args) {
        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = System.out::println;

        Consumer<String> c3 = c1.andThen(c2);

         c3.accept("hello");

         Predicate<String> checkNull = Objects::nonNull;
        Predicate<String> checkEmpty = String::isEmpty;
        Predicate<String> checkNonEmpty = checkEmpty.negate();

        Predicate<String> validString = checkNull.and(checkNonEmpty);

        System.out.println(!validString.test("dsfsdfsd"));

    //    List<String> numbers = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");
    //    Comparator<String> comparator = String::compareTo;
    //    numbers.sort(comparator);
    //     numbers.forEach(System.out::println);

    //    Comparator<String> lengthComparator = (s1, s2) -> Integer.compare(s2.length(), s1.length());
    //    numbers.sort(lengthComparator);
    //    numbers.forEach(System.out::println);

    //    ToIntFunction<String> toLength = String::length;
    //    Comparator<String> cmp = Comparator.comparingInt(toLength);
    //    numbers.sort(cmp);
    //    numbers.forEach(System.out::println);
    }
}
