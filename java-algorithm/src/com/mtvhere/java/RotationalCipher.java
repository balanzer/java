package com.mtvhere.java;

public class RotationalCipher {

    static String rotationalCipher(final String input, final int rotationFactor) {


        final StringBuilder outVal = new StringBuilder("");
        if (null != input && input.trim().length() > 0) {

            final char[] inputChars = input.toCharArray();

            for (final char item : inputChars) {
                char ciphed = item;
                if ((item >= 'A' && item <= 'Z') || (item >= 'a' && item <= 'z')) {
                    ciphed = rotateChar(item, rotationFactor);

                } else if (item >= '0' && item <= '9') {
                    ciphed = rotateNumber(item, rotationFactor);
                }
                outVal.append(ciphed);
            }
        }


        return outVal.toString();
    }

    public static char rotateNumber(final char c, final int rotationFactor) {

        char keyChar = c;

        if ((c >= '0' && c <= '9')) {
            keyChar = '0';
        }
        final int val = (c - keyChar + rotationFactor) % 10 + keyChar;
        return (char) val;
    }

    public static char rotateChar(final char c, final int rotationFactor) {

        char keyChar = c;

        if ((c >= 'A' && c <= 'Z')) {
            keyChar = 'A';
        } else if ((c >= 'a' && c <= 'z')) {
            keyChar = 'a';
        }
        final int val = (c - keyChar + rotationFactor) % 26 + keyChar;
        //System.out.println("val is : " + val);

        return (char) val;
    }

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

        // System.out.println("  9 is now : " + RotationalCipher.rotateNumber('9', 3));
        //  System.out.println("  9 is now : " + RotationalCipher.rotateNumber('0', 12));
        //  System.out.println("  Y is now : " + RotationalCipher.rotateChar('Y', 3));
        // System.out.println("  y is now : " + RotationalCipher.rotateChar('y', 3));
    }
}
