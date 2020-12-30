package com.mtvhere.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSort {
    public static void main(final String[] args) {

        final List<String> names = Arrays.asList("Murali", "apple", "Hello", "Apple", "Zebra", "Yellow");

        System.out.println("Names before sorting : " + names);
        Collections.sort(names, (a, b) -> {
            return a.compareToIgnoreCase(b);
        });

        System.out.println("Names before sorting : " + names);
    }
}
