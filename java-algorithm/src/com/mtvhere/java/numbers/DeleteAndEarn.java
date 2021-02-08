package com.mtvhere.java.numbers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DeleteAndEarn {
    public static void main(String[] args) {
        DeleteAndEarn solution = new DeleteAndEarn();
        int output = 0;
        int[] input = {3, 4, 2};
        // output = solution.deleteAndEarn(input);
        // System.out.println(Arrays.toString(input) + " has max points " + output);


        input = new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6};
        output = solution.deleteAndEarn(input);
        System.out.println(Arrays.toString(input) + " has max points " + output);
    }

    public int elementCount(int[] nums, int find) {
        int count = 0;
        for (Integer num : nums) {
            if (find == num && find != 0 && num != 0) {
                count++;
            }
        }
        return count;
    }

    public int deleteAndEarn(int[] numsInput) {
        int[] nums = new int[numsInput.length];
        System.arraycopy(numsInput, 0, nums, 0, numsInput.length);
        int points = 0;


        PriorityQueue<Integer> largerQueue = new PriorityQueue<>((a, b) -> {
            return b.compareTo(a);
        });
        for (Integer num : nums) {
            if (num > 0) {
                largerQueue.add(num);
            }
        }
        //System.out.println("Large Queue " + largerQueue);

        while (largerQueue.size() > 0) {
            int num = largerQueue.poll();
            int curCount = this.elementCount(nums, num);
            int incCount = this.elementCount(nums, num + 1);
            int decCount = this.elementCount(nums, num - 1);
            // System.out.println(num + " count is " + curCount + " inc(" + (num + 1) + ") " + incCount + " dec(" + (num - 1) + ") " + decCount);

            if (curCount > 0 && curCount >= decCount) {
                this.deleteFirstOccurence(nums, num);
                this.deleteAllOccurence(nums, num + 1);
                this.deleteAllOccurence(nums, num - 1);
                points = points + num;
            }
            // System.out.println("points " + points + "  " + Arrays.toString(nums));
        }

        return points;
    }

    private void deleteAllOccurence(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                nums[i] = 0;
            }
        }
    }

    private void deleteFirstOccurence(int[] nums, int num) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                nums[i] = 0;
                break;
            }
        }
    }
}
