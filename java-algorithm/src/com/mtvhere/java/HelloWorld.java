package com.mtvhere.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class HelloWorld {
    public static void main(final String ags[]) {
        System.out.println("Hello World!");

        final short shortVar = 9999;
        final int intVar = 2_1_1_0_2_3_3;
        System.out.println("intVar " + intVar);

        final byte byteVar = 123;
        System.out.println("byteVar " + byteVar);

        //final int[] intArray = new int[1];

        //System.out.println("intArray " + intArray[1]);

        final Set<Integer> numbers = new HashSet<>();

        IntStream.range(1, 20).forEach(num -> {
            numbers.add(num % 4);
            System.out.println("added  " + num + " to set, set size : " + numbers.size() + "  items in set : " + numbers);
        });

        Collections.synchronizedList(new ArrayList<>());


        final String sample = "Hello World";

        System.out.println("string from char array : " + new String(sample.toCharArray()));

        IntStream.range(0, sample.length()).forEach(index -> {
            System.out.println("Index " + index + " char is " + sample.charAt(index));
        });
    }
}
