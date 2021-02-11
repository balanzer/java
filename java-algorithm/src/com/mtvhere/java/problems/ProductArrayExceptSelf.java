package com.mtvhere.java.problems;


import java.util.Arrays;

public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        ProductArrayExceptSelf solution = new ProductArrayExceptSelf();
        int[] input = {1, 2, 3, 4};
        int[] output = solution.productExceptSelf(input);
        System.out.println(Arrays.toString(input) + " results " + Arrays.toString(output));
    }

    public int[] productExceptSelf(int[] nums) {
        if (null != nums && nums.length > 0) {

            int length = nums.length;
            int[] answer = new int[length];

            //init first pos answer with 1
            answer[0] = 1;

            //process left to right
            for (int i = 1; i < length; i++) {
                answer[i] = nums[i - 1] * answer[i - 1];
            }

            //System.out.println(Arrays.toString(answer));
            //process right to left
            int r = 1;
            for (int i = length - 1; i >= 0; i--) {
                answer[i] = answer[i] * r;
                r = r * nums[i];
            }

            //System.out.println(Arrays.toString(answer));

            return answer;
        }
        return null;
    }
}
