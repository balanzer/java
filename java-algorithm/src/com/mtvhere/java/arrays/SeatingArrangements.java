package com.mtvhere.java.arrays;

import java.util.Arrays;

public class SeatingArrangements {

    static int minOverallAwkwardness(final int[] arr) {
        // Write your code here

        Arrays.sort(arr);

        final int[] outarr = new int[arr.length];

        final int mid = arr.length / 2;

        final int key1 = mid;

        int key2 = 0;
        if (arr.length % 2 == 0) {
            key2 = mid - 1;
        } else {
            key2 = mid + 1;
        }

        // System.out.println("key " + key1 + " " + key2);
        System.out.println(Arrays.toString(arr));
        int count = 0;
        if (arr.length > 3) {
            outarr[count++] = arr[key1];
            outarr[count++] = arr[arr.length - 1];
            outarr[count++] = arr[key2];

        } else {
            if (arr.length == 3) {
                outarr[count++] = arr[key1];
                outarr[count++] = arr[0];
                outarr[count++] = arr[key2];
            }
        }

        //System.out.println(Arrays.toString(outarr));
        for (int i = 0; i < arr.length && arr.length > 3; i++) {
            if (i != key1 && i != key2 && i + 1 < arr.length) {
                outarr[count++] = arr[i];
            }
        }
        System.out.println(Arrays.toString(outarr));
        int minAwkwardness = Integer.MIN_VALUE;
        for (int i = 0; i < outarr.length; i++) {
            int awkwardness = 0;

            if (i + 1 == outarr.length) {
                awkwardness = Math.abs(outarr[i] - outarr[0]);
            } else {
                awkwardness = Math.abs(outarr[i] - outarr[i + 1]);

            }

            if (minAwkwardness < awkwardness) {
                minAwkwardness = awkwardness;
            }
            // System.out.println(awkwardness + "  " + minAwkwardness);
        }
        return minAwkwardness;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(final int expected, final int output) {
        final boolean result = (expected == output);
        final char rightTick = '\u2713';
        final char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + this.test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + this.test_case_number + ": Expected ");
            SeatingArrangements.printInteger(expected);
            System.out.print(" Your output: ");
            SeatingArrangements.printInteger(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printInteger(final int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        final int[] arr_1 = {5, 10, 6, 8};
        final int expected_1 = 4;
        final int output_1 = SeatingArrangements.minOverallAwkwardness(arr_1);
        this.check(expected_1, output_1);

        final int[] arr_2 = {1, 2, 5, 3, 7};
        final int expected_2 = 4;
        final int output_2 = SeatingArrangements.minOverallAwkwardness(arr_2);
        this.check(expected_2, output_2);

        final int[] arr_4 = {1, 2, 1, 1, 10, 4, 7};
        final int expected_4 = 6;
        final int output_4 = SeatingArrangements.minOverallAwkwardness(arr_4);
        this.check(expected_4, output_4);


        final int[] arr_3 = {1, 2, 4};
        final int expected_3 = 3;
        final int output_3 = SeatingArrangements.minOverallAwkwardness(arr_3);
        this.check(expected_3, output_3);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new SeatingArrangements().run();
    }

}
