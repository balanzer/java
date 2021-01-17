package com.mtvhere.java.string;

import java.io.IOException;
import java.util.HashMap;

public class MinimumLengthSubstrings {


    static boolean hasAllChars(final String s, final String t) {

        final HashMap<Character, Integer> tCount = new HashMap<>();
        final HashMap<Character, Integer> sCount = new HashMap<>();


        for (int i = 0; i < t.length(); i++) {
            final Character item = t.charAt(i);
            if (tCount.containsKey(item)) {
                tCount.put(item, tCount.get(item) + 1);
            } else {
                tCount.put(item, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            final Character item = s.charAt(i);
            if (sCount.containsKey(item)) {
                sCount.put(item, sCount.get(item) + 1);
            } else {
                sCount.put(item, 1);
            }
        }

        //System.out.println(sCount);
        // System.out.println(tCount);

        if (sCount.keySet().containsAll(tCount.keySet())) {

            boolean match = true;
            for (final char key : tCount.keySet()) {

                if (sCount.get(key) < tCount.get(key)) {
                    match = false;
                }
            }

            if (match) {
                //    System.out.println(t + " has all keys of " + s);
                return true;
            }
        }
        // System.out.println(t + " is not substring of " + s);
        return false;

    }

    static int minLengthSubstring(final String s, final String t) {
        // Write your code here
        if (hasAllChars(s, t)) {
            for (int i = t.length(); i < s.length(); i++) {
                final String newStr = s.substring(0, i);
                if (hasAllChars(newStr, t)) {
                    return i;
                }
            }
        } else {
            return -1;
        }
        return -1;
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
            MinimumLengthSubstrings.printInteger(expected);
            System.out.print(" Your output: ");
            MinimumLengthSubstrings.printInteger(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printInteger(final int n) {
        System.out.print("[" + n + "]");
    }

    public void run() throws IOException {
        final String s_1 = "dcbefebce";
        final String t_1 = "fd";
        final int expected_1 = 5;
        final int output_1 = MinimumLengthSubstrings.minLengthSubstring(s_1, t_1);
        this.check(expected_1, output_1);

        final String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        final String t_2 = "cbccfafebccdccebdd";
        final int expected_2 = -1;
        final int output_2 = MinimumLengthSubstrings.minLengthSubstring(s_2, t_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) throws IOException {
        new MinimumLengthSubstrings().run();
    }
}
