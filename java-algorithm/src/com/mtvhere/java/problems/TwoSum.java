package com.mtvhere.java.problems;

import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(final int[] nums, final int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }

        }

        return new int[]{};

    }

    public static void main(final String[] args) {
        final int[] nums = {2, 7, 11, 15};
        final int target = 9;
        final int[] out = twoSum(nums, target);
        System.out.println("Result : " + Arrays.toString(out));
    }

}
