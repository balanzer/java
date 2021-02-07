package com.mtvhere.java.arrays;

import java.util.Arrays;

public class SumOfAbsoluteDifferences {
    public static void main(String[] args) {
        SumOfAbsoluteDifferences solution = new SumOfAbsoluteDifferences();

        int[] input = {1, 1, 9997, 9997, 9997, 9997, 9997, 9997, 9997, 9997, 9998, 9998, 9998, 9998, 9999, 9999, 9999, 9999, 9999, 9999, 9999, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000};
        int[] output = solution.getSumAbsoluteDifferences(input);
        System.out.println(Arrays.toString(input) + " is " + Arrays.toString(output));

        input = new int[]{1, 4, 6, 8, 10};
        output = solution.getSumAbsoluteDifferences(input);
        System.out.println(Arrays.toString(input) + " is " + Arrays.toString(output));

    }

    public int[] getSumAbsoluteDifferences(int[] nums) {

        int[] output = new int[nums.length];

        if (nums.length <= Math.pow(10, 5)) {
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = 0; j < nums.length; j++) {
                    sum += Math.abs(nums[i] - nums[j]);
                }
                output[i] = sum;
            }
        }
        return output;
    }
}

