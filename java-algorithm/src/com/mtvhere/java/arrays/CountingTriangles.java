package com.mtvhere.java.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CountingTriangles {
    class Sides {
        int a;
        int b;
        int c;

        Sides(final int a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Sides{" +
                    "a=" + this.a +
                    ", b=" + this.b +
                    ", c=" + this.c +
                    '}';
        }
    }

    // Add any helper functions you may need here


    int countDistinctTriangles(final ArrayList<Sides> arr) {
        // Write your code here
        final HashMap<HashSet<Integer>, Integer> triangels = new HashMap<>();
        Integer count = 1;
        for (int i = 0; i < arr.size(); i++) {

            final HashSet<Integer> sides = new HashSet<>();
            final Sides item = arr.get(i);
            sides.add(item.a);
            sides.add(item.b);
            sides.add(item.c);

            triangels.put(sides, count++);

        }
        
        System.out.println(triangels);

        return triangels.size();
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
            CountingTriangles.printInteger(expected);
            System.out.print(" Your output: ");
            CountingTriangles.printInteger(output);
            System.out.println();
        }
        this.test_case_number++;
    }

    static void printInteger(final int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        final ArrayList<Sides> arr_1 = new ArrayList<>();
        arr_1.add(new Sides(7, 6, 5));
        arr_1.add(new Sides(5, 7, 6));
        arr_1.add(new Sides(8, 2, 9));
        arr_1.add(new Sides(2, 3, 4));
        arr_1.add(new Sides(2, 4, 3));
        final int expected_1 = 3;
        final int output_1 = this.countDistinctTriangles(arr_1);
        this.check(expected_1, output_1);

        final ArrayList<Sides> arr_2 = new ArrayList<>();
        arr_2.add(new Sides(3, 4, 5));
        arr_2.add(new Sides(8, 8, 9));
        arr_2.add(new Sides(7, 7, 7));
        final int expected_2 = 3;
        final int output_2 = this.countDistinctTriangles(arr_2);
        this.check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(final String[] args) {
        new CountingTriangles().run();
    }
}
