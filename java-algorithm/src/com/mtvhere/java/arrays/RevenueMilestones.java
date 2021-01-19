package com.mtvhere.java.arrays;

public class RevenueMilestones {

    static int findMilestone(final int[] revenues, final int milestones) {


        int start = 0;
        int end = revenues.length;

        while (start != end) {
            final int tot = start + end;

            int mid = tot / 2;

            if (tot % 2 == 1) {
                mid = mid + 1;
            }

            int midPrev = mid - 1;

            if (midPrev < 0) {
                midPrev = 0;
            }

            //System.out.println(start + " " + end + " " + mid + " milestone : " + milestones + " mid element : " + revenues[mid] + " prev  " + revenues[midPrev]);

            if (revenues[mid] >= milestones && revenues[midPrev] < milestones) {
                // System.out.println("found " + milestones + " at pos " + mid);
                return mid + 1; // adjusting arr starts with 0;
            }

            if (revenues[mid] >= milestones) {
                start = 0;
                end = mid;
            }

            if (revenues[mid] <= milestones) {
                start = mid;
                end = revenues.length - 1;
            }

        }


        return 0;
    }

    static int[] getMilestoneDays(final int[] revenues, final int[] milestones) {
        // Write your code here
        final int[] revenueByDays = new int[revenues.length];
        final int[] milestoneDates = new int[milestones.length];

        int total = 0;
        for (int i = 0; i < revenues.length; i++) {
            total = total + revenues[i];
            revenueByDays[i] = total;
        }

        //System.out.println("Revenues : " + Arrays.toString(revenueByDays));

        for (int i = 0; i < milestones.length; i++) {
            milestoneDates[i] = findMilestone(revenueByDays, milestones[i]);
        }


        return milestoneDates;
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
            RevenueMilestones.printIntegerArray(expected);
            System.out.print(" Your output: ");
            RevenueMilestones.printIntegerArray(output);
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
        final int[] revenues_1 = {100, 200, 300, 400, 500};
        final int[] milestones_1 = {300, 800, 1000, 1400};
        final int[] expected_1 = {2, 4, 4, 5};
        final int[] output_1 = RevenueMilestones.getMilestoneDays(revenues_1, milestones_1);
        this.check(expected_1, output_1);

        final int[] revenues_2 = {700, 800, 600, 400, 600, 700};
        final int[] milestones_2 = {3100, 2200, 800, 2100, 1000};
        final int[] expected_2 = {5, 4, 2, 3, 2};
        final int[] output_2 = RevenueMilestones.getMilestoneDays(revenues_2, milestones_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new RevenueMilestones().run();
    }
}
