package com.mtvhere.java.string;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix solution = new LongestCommonPrefix();

        String[] input = {"flower", "flow", "flight"};
        String output = solution.longestCommonPrefix(input);

        System.out.println(Arrays.toString(input) + " longest prefix is " + output);

        input = new String[]{"", "b"};
        output = solution.longestCommonPrefix(input);

        System.out.println(Arrays.toString(input) + " longest prefix is " + output);

    }

    public String longestCommonPrefix(String[] strs) {
        int minLen = -1;
        if (strs.length == 0) {
            return "";
        }
        for (String str : strs) {
            if (minLen == -1) {
                minLen = str.length();
            } else {
                minLen = Math.min(minLen, str.length());
            }
        }


        for (int i = minLen; i > 0 && minLen > 0; i--) {

            String prevString = null;
            boolean matched = true;
            for (String str : strs) {

                String newStr = str.substring(0, i);
                if (prevString == null) {
                    prevString = newStr;
                } else {
                    if (!prevString.equals(newStr)) {
                        matched = false;
                    }
                }

            }
            if (matched) {
                return prevString;
            }
        }
        return "";
    }
}
