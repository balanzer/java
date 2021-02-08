package com.mtvhere.java.string;

import java.util.HashMap;
import java.util.Map;

public class ConstructPalindromeStrings {
    public static void main(String[] args) {
        ConstructPalindromeStrings solution = new ConstructPalindromeStrings();
        String s = "sese";
        int k = 2;
        System.out.println(solution.canConstruct(s, k));

    }

    public boolean canConstruct(String s, int k) {

        if (s.length() < k) {
            return false;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        System.out.println(freq);
        int odd = 0;
        for (final int val : freq.values()) {
            if (val % 2 == 1) {
                odd++;
            }

            if (odd > k) {
                return false;
            }

        }
        return true;
    }
}
