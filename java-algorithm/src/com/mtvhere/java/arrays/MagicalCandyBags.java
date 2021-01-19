package com.mtvhere.java.arrays;

import java.util.PriorityQueue;

public class MagicalCandyBags {


    // Add any helper functions you may need here


    static int maxCandies(final int[] arr, final int k) {
        // Write your code here

        final PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b.compareTo(a);
        });

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int totalAte = 0;
        for (int i = 1; i <= k; i++) {

            final int currentAte = pq.poll();
            pq.add(currentAte / 2);
            totalAte = totalAte + currentAte;
        }

        return totalAte;
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
            MagicalCandyBags.printInteger(expected);
            System.out.print(" Your output: ");
            MagicalCandyBags.printInteger(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printInteger(final int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        final int n_1 = 5;
        final int k_1 = 3;
        final int[] arr_1 = {2, 1, 7, 4, 2};
        final int expected_1 = 14;
        final int output_1 = MagicalCandyBags.maxCandies(arr_1, k_1);
        this.check(expected_1, output_1);

        final int n_2 = 9;
        final int k_2 = 3;
        final int[] arr_2 = {19, 78, 76, 72, 48, 8, 24, 74, 29};
        final int expected_2 = 228;
        final int output_2 = MagicalCandyBags.maxCandies(arr_2, k_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new MagicalCandyBags().run();
    }
}
