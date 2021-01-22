package com.mtvhere.java.string;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * using strings
 */
public class AddingNumbers {

    private static boolean isValidNumber(final String num) {
        if (num != null && num.trim().length() > 0) {
            for (int i = num.length() - 1; i >= 0; i--) {
                if (num.charAt(i) < '0' || num.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String add(final String[] nums) {

        final Predicate<String> validate = s -> {
            return isValidNumber(s);
        };
        final List<String> numsToAdd = new ArrayList<>();

        int maxLength = 0;
        for (final String num : nums) {
            if (validate.test(num)) {
                if (maxLength < num.length()) {
                    maxLength = num.length();
                }
                numsToAdd.add(num);
            }

        }

        for (int i = 0; i < numsToAdd.size(); i++) {
            final String num = numsToAdd.get(i);

            if (num.length() < maxLength) {
                numsToAdd.remove(i);
                numsToAdd.add(i, addPreFixZero(num, maxLength));
            }
        }


        System.out.println(numsToAdd);

        for (int i = maxLength - 1; i >= 0; i--) {
            int columnSum = 0;
            final int remainder = 0;
            for (int j = 0; j < numsToAdd.size(); j++) {
                final String num = numsToAdd.get(j);

                columnSum = columnSum + Integer.parseInt("" + num.charAt(i));

            }
            System.out.println(columnSum);

            if (columnSum < 10) {

            } else {

            }
        }


        return "";
    }

    private static String addPreFixZero(final String num, final int maxLength) {
        StringBuilder prefix = new StringBuilder("");

        for (int i = num.length(); i < maxLength; i++) {
            System.out.println(i + " " + maxLength + " for " + num);
            prefix = prefix.append("0");
        }
        return prefix.append(num).toString();
    }

    public static void main(final String[] args) {

        final String[] nums = {"1", "3", "10", "12", "101", ""};
        final String result = add(nums);
        System.out.println("output : " + result);

    }


}
