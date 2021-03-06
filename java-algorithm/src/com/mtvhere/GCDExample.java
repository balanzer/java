package com.mtvhere;

public class GCDExample {

    public static void main(final String[] arg) {

        final int num1 = 8;
        final int num2 = 24;
        int gcd = 1;

        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        System.out.printf("GCD of %d and %d is: %d", num1, num2, gcd);
    }

}
