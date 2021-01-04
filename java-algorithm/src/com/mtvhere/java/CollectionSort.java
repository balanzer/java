package com.mtvhere.java;

import com.mtvhere.utils.CreateArray;

import java.util.Arrays;

public class CollectionSort {
    public static void main(final String[] args) {
        /*
        final List<String> names = Arrays.asList("Murali", "apple", "Hello", "Apple", "Zebra", "Yellow");

        System.out.println("Names before sorting : " + names);
        Collections.sort(names, (a, b) -> {
            return a.compareToIgnoreCase(b);
        });

        System.out.println("Names before sorting : " + names);  */
        final Integer[] data = CreateArray.getIntArray(20, 0, 2000);


        // Arrays.sort(data);
        //System.out.println("Integer Data After int sorting : " + Arrays.asList(data));

        Arrays.sort(data, (a, b) -> {

            final String n1 = a.toString();
            final String n2 = b.toString();

            return n1.compareTo(n2);
        });
        System.out.println("Integer Data After string sorting : " + Arrays.asList(data));
    }
}
