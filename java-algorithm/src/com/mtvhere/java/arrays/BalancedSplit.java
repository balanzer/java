package com.mtvhere.java.arrays;

import java.util.Arrays;

public class BalancedSplit {


    static int arrSum(final int[] a) {
        final int sumA = Arrays.stream(a).sum();

        return sumA;
    }

    static boolean balancedSplitExists(final int[] arr) {
        // Write your code here


        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));

        int splitIndex = arr.length / 2;
        // System.out.println(splitIndex);


        final boolean execute = true;
        while (splitIndex < arr.length && execute && splitIndex != 0) {


            final int[] a = Arrays.copyOfRange(arr, 0, splitIndex);
            final int[] b = Arrays.copyOfRange(arr, splitIndex, arr.length);

            final int sumA = arrSum(a);
            final int sumB = arrSum(b);

            // System.out.println("A is " + Arrays.toString(a) + " sum : " + sumA);
            // System.out.println("B is " + Arrays.toString(b) + " sum : " + sumB);

            if (sumA == sumB && a[a.length - 1] < b[0]) {
                return true;
            } else if (sumA == sumB && a[a.length - 1] >= b[0]) {
                return false;
            }

            if (sumA <= sumB) {
                splitIndex++;
            } else {
                splitIndex--;
            }


        }

        return false;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(final boolean expected, final boolean output) {
        final boolean result = (expected == output);
        final char rightTick = '\u2713';
        final char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + this.test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + this.test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printString(final String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        final int[] arr_1 = {2, 1, 2, 5};
        final boolean expected_1 = true;
        final boolean output_1 = BalancedSplit.balancedSplitExists(arr_1);
        this.check(expected_1, output_1);

        final int[] arr_2 = {3, 6, 3, 4, 4};
        final boolean expected_2 = false;
        final boolean output_2 = BalancedSplit.balancedSplitExists(arr_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new BalancedSplit().run();
    }
}
