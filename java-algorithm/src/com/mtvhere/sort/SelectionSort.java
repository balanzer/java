package com.mtvhere.sort;

import com.mtvhere.utils.CreateArray;

import java.util.Arrays;

public class SelectionSort {

    public static void main(final String[] args) {
        final Integer[] data = CreateArray.getIntArray(10, -200, 200);


        for (int lastUnSortedIndex = data.length - 1; lastUnSortedIndex > 0; lastUnSortedIndex--) {
            int largestItemIndex = 0;
            for (int startIndex = 1; startIndex <= lastUnSortedIndex; startIndex++) {

                if (data[startIndex] > data[largestItemIndex]) {
                    largestItemIndex = startIndex;
                }
                //  System.out.println("startIndex : " + startIndex + ", largestItemIndex : " + largestItemIndex);
            }


            // System.out.println("swapping lastUnSortedIndex : " + lastUnSortedIndex + " (" + data[lastUnSortedIndex] + ") with largestItemIndex : " + largestItemIndex + "(" + data[largestItemIndex] + ")");
            //swap item at lastUnSortedIndex with largestItemIndex
            final int existingItem = data[lastUnSortedIndex];
            data[lastUnSortedIndex] = data[largestItemIndex];
            data[largestItemIndex] = existingItem;
        }

        System.out.println("Selection Sort Result  : " + Arrays.toString(data));
    }
}
