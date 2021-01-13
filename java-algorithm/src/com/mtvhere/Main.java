package com.mtvhere;

import java.util.stream.IntStream;

public class Main {

    public static void main(final String[] args) {
        // write your code here test
        final char upper = 'A';

        //System.out.println("Upper is : " + upper + ", lower : " + (char) (upper + 26));

        final int hash = "Apple".hashCode();
        System.out.println(hash);
        IntStream.range(1, 100).forEach((i) -> {
            // System.out.println(upper + i + " is " + (char) (upper + i));
        });
    }
}
