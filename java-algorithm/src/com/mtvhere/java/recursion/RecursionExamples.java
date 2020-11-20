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

        final int num1 = 15;
        final int num2 = 20;

        final int gcdValue = gcd(num1, num2);

        System.out.println("gcd of " + num1 + " and " + num2 + " is " + gcdValue);
    }

    private static int gcd(int num1, int num2) {
        // System.out.println("gcd of " + num1 + " and " + num2);
        if (num1 < num2) {
            final int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
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
