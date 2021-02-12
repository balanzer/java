package com.mtvhere.java.numbers;

public class ConsecutiveNumbersSum {
    public static void main(String[] args) {
        ConsecutiveNumbersSum solution = new ConsecutiveNumbersSum();

        int input, output;
        /*
        input = 1;
        output = solution.consecutiveNumbersSum(input);
        System.out.println(input + " has " + output);
        */

        input = 63660706;
        output = solution.consecutiveNumbersSum(input);
        System.out.println(input + " has " + output);

        /*
        input = 15;
        output = solution.consecutiveNumbersSum(input);
        System.out.println(input + " has " + output);
         */
    }

    public int consecutiveNumbersSum(int number) {
        if (number == 1) {
            return 1;//test
        }
        if (number > Math.pow(10, 9)) {
            number = (int) Math.pow(10, 9);
        }

        int count = 1;
        int mid = number % 2 == 0 ? number / 2 : number / 2 + 1;


        for (int i = mid; i >= 1; i--) {

            int tempSum = 0;
            for (int j = i; j >= 1; j--) {
                tempSum += j;
                if (tempSum == number) {
                    count++;
                } else if (tempSum > number) {
                    break;
                }
            }
        }

        return count;
    }
}
