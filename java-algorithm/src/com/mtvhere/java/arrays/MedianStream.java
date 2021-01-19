package com.mtvhere.java.arrays;

import java.util.Arrays;

public class MedianStream {


    // Add any helper functions you may need here


    static int[] findMedian(final int[] arr) {
        // Write your code here

        final int[] out = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {

            if (i == 0) {
                out[i] = arr[i];
            } else if (i == 1) {
                out[i] = (arr[0] + arr[1]) / 2;
            } else {
                final int[] tempArr = Arrays.copyOfRange(arr, 0, i + 1);
                Arrays.sort(tempArr);
                //System.out.println(Arrays.toString(tempArr));
                if (tempArr.length % 2 == 1) {
                    out[i] = tempArr[tempArr.length / 2];
                } else {

                    final int mid = (tempArr.length / 2) - 1;
                    out[i] = (tempArr[mid] + tempArr[mid + 1]) / 2;
                }

            }
        }

        return out;
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
            MedianStream.printIntegerArray(expected);
            System.out.print(" Your output: ");
            MedianStream.printIntegerArray(output);
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
        final int[] arr_1 = {5, 15, 1, 3};
        final int[] expected_1 = {5, 10, 5, 4};
        final int[] output_1 = MedianStream.findMedian(arr_1);
        this.check(expected_1, output_1);

        final int[] arr_2 = {2, 4, 7, 1, 5, 3};
        final int[] expected_2 = {2, 3, 4, 3, 4, 3};
        final int[] output_2 = MedianStream.findMedian(arr_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new MedianStream().run();
    }
}
