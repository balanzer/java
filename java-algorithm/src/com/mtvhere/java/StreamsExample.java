package com.mtvhere.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamsExample {
    public static void main(final String args[]) {
        final List<Integer> numbers = Arrays.asList(8, 1, 1, 1, 2, 2, 3, 2, 3, 2, 4, 5, 4, 6, 7, 7, 6, 6, 7);


        numbers.forEach(item -> {
            //System.out.println(item);
        });

        numbers.stream().filter(number -> {
            return number > 3;
        }).distinct().sorted().forEach(number -> {
            System.out.println(number);
        });


        final List<String> names = Arrays.asList("Murali", "apple", "Hello", "Apple", "Zebra", "Yellow", "a", "ab", "ba");

        names.stream().map(name -> name.toUpperCase()).filter(name -> name.startsWith("A")).distinct().forEach(name -> System.out.println(name));


        IntStream.range(1, 10).map(num -> num * num).filter(num -> num % 2 == 0).forEach(System.out::println);

        //IntStream.range(1, 2).map(num -> num * num).average().ifPresent(System.out::println);


    }
}
