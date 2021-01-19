package com.mtvhere.java.arrays;

public class ElementSwapping {


    // Add any helper functions you may need here

    static void swap(final int[] arr, final int pos1, final int pos2) {
        final int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }

    static int[] findMinArray(final int[] arr, final int k) {
        // Write your code here


        int count = 0;
        while (count < k) {

            int min = Integer.MAX_VALUE;
            int swapPos = -1;
            for (int i = 0; i < arr.length && i <= k; i++) {


                if (min >= arr[i]) {
                    min = arr[i];
                    swapPos = i;
                }

                //System.out.println("min  " + min + " swapPos : " + swapPos);
            }
            // System.out.println(swapPos);
            if (swapPos != 0) {
                swap(arr, swapPos - 1, swapPos);
            }

            //System.out.println(Arrays.toString(arr));
            count++;
        }

        return arr;

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
            ElementSwapping.printIntegerArray(expected);
            System.out.print(" Your output: ");
            ElementSwapping.printIntegerArray(output);
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
        final int n_1 = 3;
        final int k_1 = 2;
        final int[] arr_1 = {5, 3, 1};
        final int[] expected_1 = {1, 5, 3};
        final int[] output_1 = ElementSwapping.findMinArray(arr_1, k_1);
        this.check(expected_1, output_1);

        final int n_2 = 5;
        final int k_2 = 3;
        final int[] arr_2 = {8, 9, 11, 2, 1};
        final int[] expected_2 = {2, 8, 9, 11, 1};
        final int[] output_2 = ElementSwapping.findMinArray(arr_2, k_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new ElementSwapping().run();
    }
}
