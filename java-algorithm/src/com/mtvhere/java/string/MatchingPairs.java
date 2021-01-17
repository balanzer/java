package com.mtvhere.java.string;

public class MatchingPairs {
    // Add any helper functions you may need here

    static int countPairs(final String s, final String t) {

        if (null != s && null != t && s.length() == t.length()) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(i)) {
                    count++;
                }
            }
            return count;
        }
        return 0;
    }

    static String swapPos(final String s, final int index1, final int index2) {

        final char[] chars = s.toCharArray();

        final char itemA = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = itemA;


        return new String(chars);
    }

    static int matchingPairs(final String s, final String t) {
        // Write your code here
        int maxPair = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                final String strForComp = swapPos(s, i, j);

                final int currCount = countPairs(strForComp, t);
                //System.out.println(strForComp + " has " + currCount);
                if (currCount > maxPair) {
                    maxPair = currCount;
                }
            }
        }

        return maxPair;
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
            MatchingPairs.printInteger(expected);
            System.out.print(" Your output: ");
            MatchingPairs.printInteger(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printInteger(final int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        final String s_1 = "abcde";
        final String t_1 = "adcbe";
        final int expected_1 = 5;
        final int output_1 = MatchingPairs.matchingPairs(s_1, t_1);
        this.check(expected_1, output_1);

        final String s_2 = "abcd";
        final String t_2 = "abcd";
        final int expected_2 = 2;
        final int output_2 = MatchingPairs.matchingPairs(s_2, t_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new MatchingPairs().run();
    }
}
