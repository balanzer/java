package com.mtvhere.java.arrays;

import java.util.Arrays;

public class CheckEquals {

    /**
     * Reverse to Make Equal
     * Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
     */

    public static void main(final String[] args) {
        final int[] arr1 = {1, 2, 3, 4, 5};
        final int[] arr2 = {5, 2, 3, 1, 4};

        System.out.println("Arrays Same : " + CheckEquals.areTheyEqual(arr1, arr2));

    }

    static boolean areTheyEqual(final int[] arr1, final int[] arr2) {

        if (null == arr1 || null == arr2) {
            return false;
        }

        if (arr1.length != arr2.length) {
            return false;
        }

        Arrays.sort(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        // System.out.println(Arrays.toString(arr1));
        // System.out.println(Arrays.toString(arr2));

        return true;
    }
}
