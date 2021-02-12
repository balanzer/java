package com.mtvhere.java.string;

public class NeedleInHaystack {
    public static void main(String[] args) {
        NeedleInHaystack solution = new NeedleInHaystack();

        String haystack, needle;
        int output;
        haystack = "hello";
        needle = "ll";
        output = solution.strStr(haystack, needle);
        System.out.println(haystack + " has " + needle + " at " + output);


        haystack = "aaaaa";
        needle = "bba";
        output = solution.strStr(haystack, needle);
        System.out.println(haystack + " has " + needle + " at " + output);

        haystack = "a";
        needle = "";
        output = solution.strStr(haystack, needle);
        System.out.println(haystack + " has " + needle + " at " + output);

    }

    public int strStr(String haystack, String needle) {
        if (null == haystack || null == needle) {
            return -1;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }


        for (int i = 0; i < haystack.length() && haystack.length() > 0 && needle.length() > 0; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean matched = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (i + j < haystack.length() && haystack.charAt(j + i) == needle.charAt(j)) {
                        continue;

                    } else {
                        matched = false;
                        break;
                    }
                }
                if (matched) {
                    return i;
                }
            }
        }
        return -1;
    }
}
