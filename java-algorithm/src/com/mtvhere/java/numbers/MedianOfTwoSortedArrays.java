package com.mtvhere.java.numbers;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2};
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        double output = solution.findMedianSortedArrays(nums1, nums2);

        System.out.println("Median : " + output);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int maxLen = Math.max(nums1.length, nums2.length);
        int totalItems = nums1.length + nums2.length;

        int nums[] = new int[totalItems];

        System.arraycopy(nums1, 0, nums, 0, nums1.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);

        Arrays.sort(nums);


        double median = 0;

        if (totalItems % 2 == 1) {
            int mid = (totalItems / 2);
            median = nums[mid];
        } else {
            int mid = (totalItems / 2);
            median = (nums[mid] + nums[mid - 1]) / 2.0;
        }

        System.out.println("Consolidated : " + Arrays.toString(nums) + " median : " + median);
        return median;
    }

 
}
