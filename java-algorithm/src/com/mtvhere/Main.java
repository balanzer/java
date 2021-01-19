package com.mtvhere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(final String[] args) {
        // write your code here test
        final char upper = 'A';

        //System.out.println("Upper is : " + upper + ", lower : " + (char) (upper + 26));

        final int hash = "Apple".hashCode();
        //System.out.println(hash);
        IntStream.range(1, 100).forEach((i) -> {
            // System.out.println(upper + i + " is " + (char) (upper + i));
        });

        final List<List<Integer>> subArrays = new ArrayList<>();
        final List<Integer> list = new ArrayList<>();
        Collections.sort(list);
        subArrays.add(list);

        final int[] arr = {4, 2, 3, 1, 5};

        final int sum = Arrays.stream(arr).sum();
        System.out.println("Sum is " + sum);


    }
}
