package com.mtvhere.java.arrays;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class TrappingRainWater {

    public static void main(final String[] args) {
        final TrappingRainWater solution = new TrappingRainWater();

        final int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expOutput = 6;
        int actOutput = 0;
        actOutput = solution.trap(input);
        System.out.println(Arrays.toString(input) + " returns " + actOutput + ", expected : " + expOutput);

        final int[] input2 = {4, 2, 0, 3, 2, 5};
        expOutput = 9;
        actOutput = 0;
        actOutput = solution.trap(input2);
        System.out.println(Arrays.toString(input2) + " returns " + actOutput + ", expected : " + expOutput);

        final int[] input3 = {1, 2, 0, 1, 2, 0, 0};
        expOutput = 3;
        actOutput = 0;
        actOutput = solution.trap(input3);
        System.out.println(Arrays.toString(input3) + " returns " + actOutput + ", expected : " + expOutput);
    }

    public int trap(final int[] height) {

        if (height.length > 2) {
            int trapLevel = 0;
            OptionalInt maxHeightOP = Arrays.stream(height).max();
            int maxHeight = 0;
            if (maxHeightOP.isPresent()) {
                maxHeight = maxHeightOP.getAsInt();
            }


            int finalMaxHeight = maxHeight;
            int maxHeightIndex = IntStream.range(0, height.length).filter(i -> {
                return finalMaxHeight == height[i];
            }).findFirst().orElse(-1);

            //System.out.println("Max Hight : " + maxHeight + " at " + maxHeightIndex);

            int leftIndex = 0;

            for (int i = 0; i < maxHeightIndex; i++) {
                if (height[leftIndex] < height[i]) {
                    leftIndex = i;
                }
                //  System.out.println("i is " + i + " leftIndex : " + leftIndex + " height[i] : " + height[i] + " height[leftIndex] : " + height[leftIndex]);
                trapLevel = trapLevel + Math.min(height[leftIndex], height[maxHeightIndex]) - height[i];
                //   System.out.println("trapLevel :" + trapLevel);
            }
            int rightIndex = height.length - 1;

            for (int i = height.length - 1;
                 i > maxHeightIndex;
                 i--) {
                if (height[rightIndex] < height[i]) {
                    rightIndex = i;
                }
                //  System.out.println("i is " + i + " rightIndex : " + rightIndex + " height[i] : " + height[i] + " height[rightIndex] : " + height[rightIndex]);
                trapLevel = trapLevel + Math.min(height[rightIndex], height[maxHeightIndex]) - height[i];
                // System.out.println("trapLevel :" + trapLevel);
            }
            return trapLevel;
        }
        return 0;
    }

}
