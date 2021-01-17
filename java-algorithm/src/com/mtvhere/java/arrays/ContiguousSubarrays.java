package com.mtvhere.java.arrays;

public class ContiguousSubarrays {
    public static void main(final String[] args) {
        new ContiguousSubarrays().run();
    }


    // Add any helper functions you may need here


    static int[] countSubarrays(final int[] arr) {
        // Write your code here

        final int[] subArrayCount = new int[arr.length];
        for (int i = 0; i < subArrayCount.length; i++) {
            subArrayCount[i] = checkPos(i, arr);
        }


        return subArrayCount;

    }

    static int checkPos(final int index, final int[] arr) {

        final int item = arr[index];
        int count = 1;//min 1 count for every item
        for (int i = index; i < arr.length && i + 1 < arr.length && arr[i + 1] <= item; i++) {
            count++;
        }

        for (int i = index - 1; i >= 0 && arr[i] <= item; i--) {
            count++;
        }

        return count;
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
            ContiguousSubarrays.printIntegerArray(expected);
            System.out.print(" Your output: ");
            ContiguousSubarrays.printIntegerArray(output);
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
        final int[] test_1 = {3, 4, 1, 6, 2};
        final int[] expected_1 = {1, 3, 1, 5, 1};
        final int[] output_1 = ContiguousSubarrays.countSubarrays(test_1);
        this.check(expected_1, output_1);

        final int[] test_2 = {2, 4, 7, 1, 5, 3};
        final int[] expected_2 = {1, 2, 6, 1, 3, 1};
        final int[] output_2 = ContiguousSubarrays.countSubarrays(test_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }
}
