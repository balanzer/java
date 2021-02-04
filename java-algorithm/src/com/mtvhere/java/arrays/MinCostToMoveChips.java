package com.mtvhere.java.arrays;

import java.util.Arrays;

public class MinCostToMoveChips {
    public static void main(String[] args) {
        MinCostToMoveChips solution = new MinCostToMoveChips();
        int[] input = {1, 2, 3};
        int expectedOutput = 1;
        int output = solution.minCostToMoveChips(input);

        System.out.println(Arrays.toString(input) + " outputs " + output + ", expected : " + expectedOutput);
        input = new int[]{2, 2, 2, 3, 3};
        expectedOutput = 2;
        output = solution.minCostToMoveChips(input);

        System.out.println(Arrays.toString(input) + " outputs " + output + ", expected : " + expectedOutput);


    }

    public int minCostToMoveChips(int[] position) {

        int oddCount = 0;
        int evenCount = 0;

        for (int i : position) {
            if (i % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        return Math.min(oddCount, evenCount);
    }
}

