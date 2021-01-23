package com.mtvhere.java.arrays;

import java.util.Arrays;

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        BestTimetoBuyandSellStock main = new BestTimetoBuyandSellStock();

        int[] prices = {7, 1, 5, 3, 6, 4};
        int expOutput = 5;
        int actOutput = 0;

        actOutput = main.maxProfit(prices);
        System.out.println(Arrays.toString(prices) + " max profit is : " + actOutput + ", expected output : " + expOutput);

        prices = new int[]{7, 6, 4, 3, 1};
        expOutput = 0;
        actOutput = main.maxProfit(prices);
        System.out.println(Arrays.toString(prices) + " max profit is : " + actOutput + ", expected output : " + expOutput);


        prices = new int[]{2, 4, 1};
        expOutput = 2;
        actOutput = main.maxProfit(prices);
        System.out.println(Arrays.toString(prices) + " max profit is : " + actOutput + ", expected output : " + expOutput);

        prices = new int[]{3, 2, 6, 5, 0, 3};
        expOutput = 4;
        actOutput = main.maxProfit(prices);
        System.out.println(Arrays.toString(prices) + " max profit is : " + actOutput + ", expected output : " + expOutput);

    }


    private int minIndex(int[] arr, int start, int end) {

        int minIndex = -1;
        int min = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            if (arr[i] < min) {
                minIndex = i;
                min = arr[i];
            }

        }
        return minIndex;

    }

    private int maxIndex(int[] arr, int start, int end) {
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public int findMaxProfit(int[] prices) {

        if (prices.length > 1) {
            // System.out.println("Input : " + Arrays.toString(prices));
            int minIndex = this.minIndex(prices, 0, prices.length);
            int maxIndex = -1;
            if (minIndex > -1) {
                maxIndex = this.maxIndex(prices, minIndex + 1, prices.length);
            }


            // System.out.println("Min at " + minIndex + ", max at " + maxIndex);
            if (minIndex > -1 && maxIndex > -1) {
                return prices[maxIndex] - prices[minIndex];
            } else {
                return 0;
            }
        }
        return 0;
    }

    public int maxProfit(int[] prices) {
        int minIndex = this.minIndex(prices, 0, prices.length);
        int max = 0;
        int copyRange = prices.length;

        while (true) {
            int pricesnew[] = Arrays.copyOfRange(prices, 0, copyRange);

            int tempMax = this.findMaxProfit(pricesnew);
            // System.out.println(tempMax);
            max = Math.max(tempMax, max);
            copyRange = minIndex;
            minIndex = this.minIndex(prices, 0, minIndex);
            // System.out.println("max is " + max + " copyRange : " + copyRange + " minIndex : " + minIndex);
            if (minIndex < 0) {
                break;
            }
        }

        return max;
    }
}
