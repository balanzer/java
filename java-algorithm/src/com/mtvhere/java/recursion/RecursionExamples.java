package com.mtvhere.java.recursion;

import com.mtvhere.utils.CreateArray;

public class RecursionExamples {

    public static void main(final String[] args) {
        final Integer[] data = CreateArray.getIntArray(10, 1, 100);
        reverseList(data, 0);
        System.out.println("****************************");
        final int num = 30;
        final int factorial = factorial(num);
        System.out.println("factorial of " + num + " is " + factorial);

        System.out.println("****************************");
    }

    private static int factorial(final int num) {
        if (num == 1) {
            return num;
        }
        return num * factorial(num - 1);
    }

    public static void reverseList(final Integer[] num, final int currentIndex) {
        if (currentIndex < num.length) {
            reverseList(num, currentIndex + 1);
            System.out.print(num[currentIndex] + " ");
        }
    }
}
