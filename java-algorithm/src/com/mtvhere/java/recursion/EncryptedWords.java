package com.mtvhere.java.recursion;

public class EncryptedWords {
    // Add any helper functions you may need here

    static String encrypt(final String s) {
        if (s.length() > 2) {
            int mid = s.length() / 2;
            if (s.length() % 2 == 0) {
                mid--;
            }

            return s.charAt(mid) + encrypt(s.substring(0, mid)) + encrypt(s.substring(mid + 1, s.length()));
        } else {
            return s;
        }


    }

    static String findEncryptedWord(final String s) {
        // Write your code here
        return encrypt(s);
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(final String expected, final String output) {
        final boolean result = (expected.equals(output));
        final char rightTick = '\u2713';
        final char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + this.test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + this.test_case_number + ": Expected ");
            EncryptedWords.printString(expected);
            System.out.print(" Your output: ");
            EncryptedWords.printString(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printString(final String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        final String s_1 = "abc";
        final String expected_1 = "bac";
        final String output_1 = EncryptedWords.findEncryptedWord(s_1);
        this.check(expected_1, output_1);

        final String s_2 = "abcd";
        final String expected_2 = "bacd";
        final String output_2 = EncryptedWords.findEncryptedWord(s_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

        final String s_3 = "facebook";
        final String expected_3 = "eafcobok";
        final String output_3 = EncryptedWords.findEncryptedWord(s_3);
        this.check(expected_3, output_3);

    }

    public static void main(final String[] args) {
        new EncryptedWords().run();
    }
}
