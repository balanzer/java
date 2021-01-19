package com.mtvhere.java.arrays;

import java.util.Arrays;

public class AdobeAverageSubArray {


    public static void main(final String[] args) {
        final int[] arr = {4, 2, 3, 1, 5};

        final int sum = Arrays.stream(arr).sum();
        System.out.println("Sum is " + sum);


    }
}
