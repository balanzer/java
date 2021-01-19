package com.mtvhere.java;

public class Fibonacci {
    public static void main(final String[] args) {

        fibonacci(1);
        fibonacci(2);
        fibonacci(8);
        fibonacci(20);
    }

    static void fibonacci(final int toRange) {


        int t1 = 0;
        int t2 = 1;


        for (int i = 0; i < toRange; i++) {
            System.out.print(t1 + " ");
            final int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
        }


        System.out.println("");
    }
}
