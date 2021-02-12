package com.mtvhere.java.numbers;

public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger solution = new ReverseInteger();

        int input, output, expOutput;

        input = 123;
        expOutput = 321;
        output = solution.reverse(input);
        System.out.println(output != expOutput ? input + " reverse does not match " + output + ", expected " + expOutput : "" + input + " reversed correctly");

        input = -123;
        expOutput = -321;
        output = solution.reverse(input);
        System.out.println(output != expOutput ? input + " reverse does not match " + output + ", expected " + expOutput : "" + input + " reversed correctly");

        input = 120;
        expOutput = 21;
        output = solution.reverse(input);
        System.out.println(output != expOutput ? input + " reverse does not match " + output + ", expected " + expOutput : "" + input + " reversed correctly");
    }


    public int reverse(int x) {

        int num = Math.abs(x);
        long temp = 0;

        while (x != 0) {
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        if (temp < Integer.MIN_VALUE || temp > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) temp;
        
    }
}