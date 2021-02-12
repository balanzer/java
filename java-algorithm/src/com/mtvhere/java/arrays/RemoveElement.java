package com.mtvhere.java.arrays;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement solution = new RemoveElement();

        int[] input = {3, 2, 2, 3};
        int output = solution.removeElement(input, 3);
        System.out.println(Arrays.toString(input) + " after removing  length is : " + output);

        input = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        output = solution.removeElement(input, 2);
        System.out.println(Arrays.toString(input) + " after removing  length is : " + output);


    }

    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
