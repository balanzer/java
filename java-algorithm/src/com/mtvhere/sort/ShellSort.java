package com.mtvhere.sort;

import com.mtvhere.utils.CreateArray;

import java.util.Arrays;

public class ShellSort {

    public static void main(final String[] args) {

        final Integer[] data = CreateArray.getIntArray(20, -200, 200);

        for (int gap = data.length / 2; gap > 0; gap = gap / 2) {


            for (int i = gap; i < data.length; i++) {
                final int newElement = data[i];
                int j = i;

                while (j >= gap && data[j - gap] > newElement) {
                    data[j] = data[j - gap];
                    j = j - gap;
                }

                data[j] = newElement;
            }

        }

        System.out.println("ShellSort result : " + Arrays.toString(data));
    }
}
