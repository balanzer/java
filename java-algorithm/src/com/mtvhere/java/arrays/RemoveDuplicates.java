package com.mtvhere.java.arrays;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates solution = new RemoveDuplicates();

        int[] input = {1, 1, 2};
        int output = solution.removeDuplicates(input);
        System.out.println(Arrays.toString(input) + " after removing duplicate length is : " + output);

        input = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        output = solution.removeDuplicates(input);
        System.out.println(Arrays.toString(input) + " after removing duplicate length is : " + output);

    }

    public int removeDuplicates(int[] nums) {

        int len = 0;
        int currIndex = 0;
        int lastMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > lastMax) {
                //System.out.println("Valid " + nums[i]);
                lastMax = nums[i];
                nums[currIndex++] = lastMax;
                len++;
            } else {
                //this.swapOnePos(nums, i);
            }
            //  System.out.println(Arrays.toString(nums));
        }


        return len;
    }

    private void swapOnePos(int[] nums, int currIndex) {
        for (int i = currIndex; i < (nums.length - 1); i++) {
            nums[i] = nums[i + 1];
        }
    }
}
