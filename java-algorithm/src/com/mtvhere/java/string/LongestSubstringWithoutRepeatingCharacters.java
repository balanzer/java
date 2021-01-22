package com.mtvhere.java.string;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(final String[] args) {
        final LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

        String s = "abcabcbb";
        System.out.println(s + "  Longest Substring WithoutRepeating Characters length : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
        s = "bbbbb";
        System.out.println(s + "  Longest Substring WithoutRepeating Characters length : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(s + "  Longest Substring WithoutRepeating Characters length : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
        s = "";
        System.out.println(s + "  Longest Substring WithoutRepeating Characters length : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));
        s = " ";
        System.out.println(s + "  Longest Substring WithoutRepeating Characters length : " + LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(final String s) {
        int length = 0;
        int max = 0;
        if (s != null) {
            StringBuilder processedChars = new StringBuilder("");
            for (int i = 0; i < s.length(); i++) {
                // System.out.println("processedChars : " + processedChars.toString());
                if (i == 0) {
                    length = 1;
                    max = 1;
                    processedChars = processedChars.append(s.charAt(i));
                } else {
                    if (processedChars.toString().indexOf(s.charAt(i)) == -1) {
                        length++;
                        processedChars = processedChars.append(s.charAt(i));
                    } else {
                        if (max < length) {
                            max = length;
                        }
                        length = 1;
                    }

                }
            }
            if (max < length) {
                max = length;
            }
            return max;
        }
        return 0;
    }
}
