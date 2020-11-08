package com.mtvhere.sort;

import com.mtvhere.utils.CreateArray;

import java.util.Arrays;

public class InsertionSort {
    public InsertionSort() {
    }

    public static void main(final String[] args) {
        final Integer[] data = CreateArray.getIntArray(10, -200, 200);


        for (int firstUnsortedIndex = 1; firstUnsortedIndex < data.length; firstUnsortedIndex++) {

            final int newElement = data[firstUnsortedIndex];
            int i;

            for (i = firstUnsortedIndex; i > 0 && data[i - 1] > newElement; i--) {
                data[i] = data[i - 1];
            }
            data[i] = newElement;

            //System.out.println(firstUnsortedIndex + " loop result : " + Arrays.toString(data));

        }

        System.out.println("InsertionSort result : " + Arrays.toString(data));
    }
}
