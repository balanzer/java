package com.mtvhere.sort;

import com.mtvhere.utils.CreateArray;

import java.util.Arrays;

public class BubbleSort {

    public static void main(final String[] args) {
        final Integer[] data = CreateArray.getIntArray(10, -2, 2);

        if (null != data && data.length > 0) {
            for (int lastUnsortedIndex = data.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

                for (int i = 0; i < lastUnsortedIndex; i++) {

                    if (data[i] > data[i + 1]) {
                        final int tmp = data[i];
                        data[i] = data[i + 1];
                        data[i + 1] = tmp;
                    }

                }
            }
        }
        System.out.println("Bubble Sort Result  : " + Arrays.toString(data));
    }
}
