package com.mtvhere.java.arrays;

public class MinimizingPermutations {
    // Add any helper functions you may need here

    static int maxcount = 0;


    static void reverseArr(final int[] arr, final int stPos, final int edPos) {
        //System.out.println("reverse " + stPos + " to " + edPos);
        final int[] tempArr = new int[(edPos - stPos) + 1];
        int tmpCount = 0;
        int swapStPos = stPos;
        for (int i = stPos; i <= edPos; i++) {
            tempArr[tmpCount++] = arr[i];
        }

        for (int i = tempArr.length - 1; i >= 0; i--) {
            arr[swapStPos++] = tempArr[i];
        }
    }

    static boolean isArraySorted(final int[] arr) {

        maxcount++;
        if (maxcount >= 10) {
            return true;
        }
        boolean sorted = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            // System.out.println("array is sorted");
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            // System.out.print(arr[i]);
        }
        //  System.out.println("array not sorted");
        return false;
    }

    static int minOperations(final int[] arr) {
        // Write your code here

        int totalOperations = 0;
        while (!isArraySorted(arr)) {
            int stPos = -1;
            int edPos = -1;

            for (int i = 0; i < arr.length - 1; i++) {

                if (arr[i] >= arr[i + 1] && stPos == -1) {

                    stPos = i;
                    //System.out.println(" stPos is " + stPos + " for " + arr[i] + " and " + arr[i + 1]);
                }
                if (arr[i] <= arr[i + 1] && stPos != -1 && i != stPos) {
                    edPos = i;
                    // System.out.println(" edPos is " + edPos + " for " + arr[i] + " and " + arr[i + 1]);
                }


            }


            if (stPos != -1 && edPos == -1) {
                edPos = arr.length - 1;
            }

            if (stPos < edPos) {
                totalOperations++;
                reverseArr(arr, stPos, edPos);
            }

        }


        return totalOperations;
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
            MinimizingPermutations.printInteger(expected);
            System.out.print(" Your output: ");
            MinimizingPermutations.printInteger(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printInteger(final int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {

        final int n_1 = 5;
        final int[] arr_1 = {1, 2, 5, 4, 3};
        final int expected_1 = 1;
        final int output_1 = MinimizingPermutations.minOperations(arr_1);
        this.check(expected_1, output_1);

        final int n_2 = 3;
        final int[] arr_2 = {3, 1, 2};
        final int expected_2 = 2;
        final int output_2 = MinimizingPermutations.minOperations(arr_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new MinimizingPermutations().run();
    }
}
