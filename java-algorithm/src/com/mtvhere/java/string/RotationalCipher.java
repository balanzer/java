package com.mtvhere.java.string;

public class RotationalCipher {
    static String rotationalCipher(final String input, final int rotationFactor) {
        // Write your code here
        final StringBuilder output = new StringBuilder("");

        for (int i = 0; i < input.length(); i++) {
            final char item = input.charAt(i);
            output.append(transform(item, rotationFactor));
        }


        return output.toString();
    }

    static String transform(final char item, final int rotationFactor) {
        char outChar = '0';
        if (item >= 'A' && item <= 'Z') {
            final char offsetChar = 'A';
            final int offset = (item - offsetChar + (rotationFactor % 26)) % 26;

            outChar = (char) (offsetChar + offset);
            // System.out.println(item + " to " + offset + " " + outChar + " " + rotationFactor);
        } else if (item >= 'a' && item <= 'z') {

            final char offsetChar = 'a';
            final int offset = (item - offsetChar + (rotationFactor % 26)) % 26;
            outChar = (char) (offsetChar + offset);

        } else if (item >= '0' && item <= '9') {
            final char offsetChar = '0';
            final int offset = (item - offsetChar + (rotationFactor % 10)) % 10;
            outChar = (char) (offsetChar + offset);
        } else {
            outChar = item;
        }
        return Character.toString(outChar);
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
            RotationalCipher.printString(expected);
            System.out.print(" Your output: ");
            RotationalCipher.printString(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printString(final String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        final String input_1 = "All-convoYs-9-be:Alert1.";
        final int rotationFactor_1 = 4;
        final String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        final String output_1 = RotationalCipher.rotationalCipher(input_1, rotationFactor_1);
        this.check(expected_1, output_1);

        final String input_2 = "abcdZXYzxy-999.@";
        final int rotationFactor_2 = 200;
        final String expected_2 = "stuvRPQrpq-999.@";
        final String output_2 = RotationalCipher.rotationalCipher(input_2, rotationFactor_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new RotationalCipher().run();
    }
}
