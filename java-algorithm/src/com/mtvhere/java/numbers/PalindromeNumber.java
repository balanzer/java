package com.mtvhere.java.numbers;

public class PalindromeNumber {

    public static void main(String[] args) {
        int input;
        boolean output, expOutput;

        PalindromeNumber solution = new PalindromeNumber();

        input = 123;
        expOutput = false;
        output = solution.isPalindrome(input);
        System.out.println(output != expOutput ? input + " failed  does not match " + output + ", expected " + expOutput : "" + input + " passed");

        input = 121;
        expOutput = true;
        output = solution.isPalindrome(input);
        System.out.println(output != expOutput ? input + " failed  does not match " + output + ", expected " + expOutput : "" + input + " passed");

        input = 120;
        expOutput = false;
        output = solution.isPalindrome(input);
        System.out.println(output != expOutput ? input + " failed  does not match " + output + ", expected " + expOutput : "" + input + " passed");

    }


    public boolean isPalindrome(int x) {
        int tempX = x;
        if (x < 0) {
            return false;
        }

        int temp = 0;
        while (x != 0) {
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        
        return tempX == temp;
    }
}
