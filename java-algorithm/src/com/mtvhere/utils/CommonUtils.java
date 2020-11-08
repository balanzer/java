package com.mtvhere.utils;

public class CommonUtils {
    public static void swap(final Integer[] data, final int itemPosition1, final int itemPosition2) {
        if (null != data && data.length > 1 && data.length >= itemPosition1 && data.length >= itemPosition2) {
            final Integer tempVal = data[itemPosition1];
            data[itemPosition1] = data[itemPosition2];
            data[itemPosition1] = tempVal;
        } else {
            System.out.println("Array data cannot be swapped for given index (" + itemPosition1 + ") and (" + itemPosition2 + ")");
        }

    }
}
