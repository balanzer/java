package com.mtvhere.utils;

import java.util.Arrays;
import java.util.Random;

public class CreateArray {

    public static Integer[] getIntArray(int size, final int min, int max) {
        if (size <= 0) {
            size = 0;
        }
        if (max <= 0) {
            max = 100;
        }
        if (size == 0) {
            return null;
        }
        final Integer[] intArr = new Integer[size];

        for (int i = 0; i < size; i++) {
            intArr[i] = new Random().nextInt(max - min) + min;
        }

        System.out.println("Generated Int Array : " + Arrays.toString(intArr));

        return intArr;
    }

}
