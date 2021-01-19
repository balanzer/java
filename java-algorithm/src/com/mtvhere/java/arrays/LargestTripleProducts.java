package com.mtvhere.java.arrays;

import java.util.PriorityQueue;
import java.util.Queue;

public class LargestTripleProducts {

    // Add any helper functions you may need here


    static int[] findMaxProduct(final int[] arr) {
        // Write your code here
       /*
        final Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return b.compareTo(a);
        });

        System.out.println(pq); */

        final int[] outarr = new int[arr.length];


        for (int i = 0; i < arr.length; i++) {
            //System.out.println(i);
            if (i < 2) {
                outarr[i] = -1;
            } else {
                final Queue<Integer> tmpQ = new PriorityQueue<>((a, b) -> {
                    return b.compareTo(a);
                });

                for (int key = 0; key <= i; key++) {
                    tmpQ.add(arr[key]);
                }

                int product = 0;

                // System.out.println(tmpQ);

                final int num1 = tmpQ.poll();
                final int num2 = tmpQ.poll();
                final int num3 = tmpQ.poll();


                final boolean indexNumRemoved = false;
                //System.out.println("before " + num1 + " " + num2 + " " + num3 + " " + arr[i]);
                // System.out.println("after " + num1 + " " + num2 + " " + num3 + " " + arr[i]);

                product = num1 * num2 * num3;
                outarr[i] = product;
            }


        }


        return outarr;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(final int[] expected, final int[] output) {
        final int expected_size = expected.length;
        final int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        final char rightTick = '\u2713';
        final char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + this.test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + this.test_case_number + ": Expected ");
            LargestTripleProducts.printIntegerArray(expected);
            System.out.print(" Your output: ");
            LargestTripleProducts.printIntegerArray(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printIntegerArray(final int[] arr) {
        final int len = arr.length;
        System.out.print("[");
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        final int[] arr_1 = {1, 2, 3, 4, 5};
        final int[] expected_1 = {-1, -1, 6, 24, 60};
        final int[] output_1 = LargestTripleProducts.findMaxProduct(arr_1);
        this.check(expected_1, output_1);

        final int[] arr_2 = {2, 4, 7, 1, 5, 3};
        final int[] expected_2 = {-1, -1, 56, 56, 140, 140};
        final int[] output_2 = LargestTripleProducts.findMaxProduct(arr_2);
        this.check(expected_2, output_2);


        final int[] arr_3 = {2, 1, 2, 1, 2};
        final int[] expected_3 = {-1, -1, 4, 4, 8};
        final int[] output_3 = LargestTripleProducts.findMaxProduct(arr_3);
        this.check(expected_3, output_3);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new LargestTripleProducts().run();
    }
}
