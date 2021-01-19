package com.mtvhere.java.arrays;

public class BillionUsers {


    // Add any helper functions you may need here

    static double userOnDay(final float rate, final int day) {
        return Math.pow(rate, day);
    }

    static int getBillionUsersDay(final float[] growthRates) {
        // Write your code here
        int start = 1;
        int end = 2000;
        final double target = 1_000_000_000;


        while (start < end) {
            double total = 0;
            int mid = (start + end) / 2;

            if ((start + end) % 2 == 0) {
                mid = mid + 1;
            }

            // calculate mid value
            for (final float growthRate : growthRates) {
                total += userOnDay(growthRate, mid);
            }
            // System.out.println(total + " on " + mid + " st : " + start + " end " + end + " ");
            if (total == target) {
                //System.out.println(total + " reached on " + mid + " target is " + target);
                return mid;
            }
            if (total > target) {
                end = mid;
            } else {
                start = mid + 1;
            }

            //ystem.out.println("next round " + start + " " + end);
        }
        System.out.println(" return start : " + start);

        return start;
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
            BillionUsers.printInteger(expected);
            System.out.print(" Your output: ");
            BillionUsers.printInteger(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printInteger(final int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        final float[] test_1 = {1.1f, 1.2f, 1.3f};
        final int expected_1 = 79;
        final int output_1 = BillionUsers.getBillionUsersDay(test_1);
        this.check(expected_1, output_1);

        final float[] test_2 = {1.01f, 1.02f};
        final int expected_2 = 1047;
        final int output_2 = BillionUsers.getBillionUsersDay(test_2);
        this.check(expected_2, output_2);


        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new BillionUsers().run();
    }
}
