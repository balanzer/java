package com.mtvhere.java.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class SlowSums {

    // Add any helper functions you may need here


    static int getTotalTime(final int[] arr) {
        // Write your code here

        final Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
            return b.compareTo(a);
        });

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int penalty = 0;


        while (pq.size() > 1) {

            final int first = pq.poll();
            final int second = pq.poll();

            final int total = first + second;
            penalty = penalty + total;
            pq.add(total);

            //System.out.println(pq);
        }

        return penalty;
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
            SlowSums.printInteger(expected);
            System.out.print(" Your output: ");
            SlowSums.printInteger(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printInteger(final int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        final int[] arr_1 = {4, 2, 1, 3};
        final int expected_1 = 26;
        final int output_1 = SlowSums.getTotalTime(arr_1);
        this.check(expected_1, output_1);

        final int[] arr_2 = {2, 3, 9, 8, 4};
        final int expected_2 = 88;
        final int output_2 = SlowSums.getTotalTime(arr_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new SlowSums().run();
    }
}
