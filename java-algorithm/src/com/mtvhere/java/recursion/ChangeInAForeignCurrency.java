package com.mtvhere.java.recursion;

import java.util.Arrays;

public class ChangeInAForeignCurrency {

    private static boolean checkChange(final int index, final int[] denominations, int targetMoney) {
        /*
        for (int i = denominations.length - 1; i >= 0; i--) {
            targetMoney = targetMoney % denominations[i];
            if (targetMoney <= 0) {
                return true;
            }

        }

        return false;

        */
        // System.out.println(targetMoney + " index " + index);
        if (targetMoney <= 0) {
            return true;
        }
        targetMoney = targetMoney % denominations[index];
        //System.out.println(targetMoney + " left on  index " + index);
        if (index <= 0) {
            return false;
        }

        return checkChange(index - 1, denominations, targetMoney);
    }


    static boolean canGetExactChange(final int targetMoney, final int[] denominations) {

        // Write your code here
        Arrays.sort(denominations);

        return checkChange(denominations.length - 1, denominations, targetMoney);
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
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        final int target_1 = 94;
        final int[] arr_1 = {5, 10, 25, 100, 200};
        final boolean expected_1 = false;
        final boolean output_1 = ChangeInAForeignCurrency.canGetExactChange(target_1, arr_1);
        this.check(expected_1, output_1);

        final int target_2 = 75;
        final int[] arr_2 = {4, 17, 29};
        final boolean expected_2 = true;
        final boolean output_2 = ChangeInAForeignCurrency.canGetExactChange(target_2, arr_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new ChangeInAForeignCurrency().run();
    }
}
