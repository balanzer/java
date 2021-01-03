package com.mtvhere.java.arrays;


/**
 * Passing Yearbooks
 * There are n students, numbered from 1 to n, each with their own yearbook. They would like to pass their yearbooks around and get them signed by other students.
 * You're given a list of n integers arr[1..n], which is guaranteed to be a permutation of 1..n (in other words, it includes the integers from 1 to n exactly once each, in some order). The meaning of this list is described below.
 * Initially, each student is holding their own yearbook. The students will then repeat the following two steps each minute: Each student i will first sign the yearbook that they're currently holding (which may either belong to themselves or to another student), and then they'll pass it to student arr[i-1]. It's possible that arr[i-1] = i for any given i, in which case student i will pass their yearbook back to themselves. Once a student has received their own yearbook back, they will hold on to it and no longer participate in the passing process.
 * It's guaranteed that, for any possible valid input, each student will eventually receive their own yearbook back and will never end up holding more than one yearbook at a time.
 * You must compute a list of n integers output, whose element at i-1 is equal to the number of signatures that will be present in student i's yearbook once they receive it back.
 * Signature
 * int[] findSignatureCounts(int[] arr)
 * Input
 * n is in the range [1, 100,000].
 * Each value arr[i] is in the range [1, n], and all values in arr[i] are distinct.
 * Output
 * Return a list of n integers output, as described above.
 * Example 1
 * n = 2
 * arr = [2, 1]
 * output = [2, 2]
 * Pass 1:
 * Student 1 signs their own yearbook. Then they pass the book to the student at arr[0], which is Student 2.
 * Student 2 signs their own yearbook. Then they pass the book to the student at arr[1], which is Student 1.
 * Pass 2:
 * Student 1 signs Student 2's yearbook. Then they pass it to the student at arr[0], which is Student 2.
 * Student 2 signs Student 1's yearbook. Then they pass it to the student at arr[1], which is Student 1.
 * Pass 3:
 * Both students now hold their own yearbook, so the process is complete.
 * Each student received 2 signatures.
 * Example 2
 * n = 2
 * arr = [1, 2]
 * output = [1, 1]
 * Pass 1:
 * Student 1 signs their own yearbook. Then they pass the book to the student at arr[0], which is themself, Student 1.
 * Student 2 signs their own yearbook. Then they pass the book to the student at arr[1], which is themself, Student 2.
 * Pass 2:
 * Both students now hold their own yearbook, so the process is complete.
 * Each student received 1 signature.
 */
public class YearBook {

    // Add any helper functions you may need here


    static int[] findSignatureCounts(final int[] arr) {

        if (null != arr && arr.length > 0) {
            final int[] signCount = new int[arr.length];
            final int[] nextStudent = new int[arr.length];

            //First Pass
            for (int i = 0; i < signCount.length; i++) {
                //System.out.println(i + "  " + signCount[i]);

                //signs their own yearbook
                signCount[i] = 1;
                nextStudent[i] = i + 1;


            }


            //for all students/pass
            for (int pass = 2; pass <= signCount.length; pass++) {

                for (int i = 0; i < signCount.length; i++) {
                    if (nextStudent[i] != arr[i]) {
                        signCount[i] = signCount[i] + 1;
                        nextStudent[i] = arr[i];
                    }
                }

            }


            return signCount;
        }
        return null;
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
            YearBook.printIntegerArray(expected);
            System.out.print(" Your output: ");
            YearBook.printIntegerArray(output);
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
        final int[] arr_1 = {2, 1};
        final int[] expected_1 = {2, 2};
        final int[] output_1 = YearBook.findSignatureCounts(arr_1);
        this.check(expected_1, output_1);

        final int[] arr_2 = {1, 2};
        final int[] expected_2 = {1, 1};
        final int[] output_2 = YearBook.findSignatureCounts(arr_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

        final int[] arr_3 = {1, 3, 2, 4};
        final int[] expected_3 = {1, 2, 2, 1};
        final int[] output_3 = YearBook.findSignatureCounts(arr_3);
        this.check(expected_3, output_3);
    }

    public static void main(final String[] args) {
        new YearBook().run();
    }
}
