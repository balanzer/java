package com.mtvhere.java.search;

import java.util.Arrays;

public class SearchInsertPosition {
    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();

        int[] input = {1, 3, 5, 6};
        int target = 5;
        int output = solution.searchInsert(input, target);

        System.out.println(Arrays.toString(input) + " has or insert at pos " + target + " at " + output);


        input = new int[]{1, 3, 5, 6};
        target = 2;
        output = solution.searchInsert(input, target);

        System.out.println(Arrays.toString(input) + " has or insert at pos " + target + " at " + output);

        input = new int[]{1, 3, 5, 6};
        target = 7;
        output = solution.searchInsert(input, target);

        System.out.println(Arrays.toString(input) + " has or insert at pos " + target + " at " + output);

        input = new int[]{1, 3, 5, 6};
        target = 0;
        output = solution.searchInsert(input, target);

        System.out.println(Arrays.toString(input) + " has or insert at pos " + target + " at " + output);

        input = new int[]{1, 3};
        target = 1;
        output = solution.searchInsert(input, target);

        System.out.println(Arrays.toString(input) + " has or insert at pos " + target + " at " + output);

    }

    public int searchInsert(int[] nums, int target) {
        if (nums.length > 0) {
            return this.find(0, nums.length, target, nums);
        }
        return 0;
    }

    private int find(int start, int end, int target, int[] nums) {


        int mid = (start + end) / 2;


        if (nums[mid] == target) {
            return mid;
        } else {
            // System.out.println("\t\t  mid " + mid + " target " + target + " on " + Arrays.toString(nums) + " nums[" + mid + "] is " + nums[mid]);

            if (target > nums[mid]) {
                if (mid + 1 < nums.length && target > nums[mid + 1]) {
                    return this.find(mid + 1, nums.length, target, nums);
                } else {
                    return mid + 1;
                }

            } else {
                if (mid > 0 && target < nums[mid - 1]) {
                    return this.find(0, mid - 1, target, nums);
                } else {
                    if (mid <= 0) {
                        return 0;
                    }
                    return mid;
                }


            }

        }

    }
}
