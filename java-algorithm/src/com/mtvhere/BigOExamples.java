package com.mtvhere;

public class BigOExamples {
    public static void main(final String[] args) {
        //Constant Time Algorithms – O(1)


        //Clearly, it doesn't matter what n is, above. This piece of code takes a constant amount of time to run. It's not dependent on the size of n.

        //O(1)
        int n = 1000;
        System.out.println("Hey - your input is: " + n);
        //O(2)
        n = 1000;
        final int m = 200;
        System.out.println("Hey - your input is: " + n + " and " + m);

        //Logarithmic Time Algorithms – O(log n)
        //Constant time algorithms are the quickest. Logarithmic time is the next quickest.
        //running time grows in proportion to the logarithm of the input (in this case, log to the base 2):

        n = 20;
        for (int i = 1; i <= n; i = i * 2) {
            System.out.println("Hey - I'm busy looking at: " + i);
        }


        // Linear Time Algorithms – O(n)
        //something grows linearly, we mean that it grows directly proportional to the size of its inputs.

        for (int i = 0; i < n; i++) {
            System.out.println("Hey - I'm busy looking at: " + i);
        }

        //N Log N Time Algorithms – O(n log n)
        //The running time grows in proportion to n log n of the input:
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j = j * 2) {
                System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
            }
        }
        // Quadratic or Polynomial Time Algorithms – O(np)

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
            }
        }
      
    }
}
