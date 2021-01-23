package com.mtvhere.java.string;

import java.util.Arrays;

public class VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        VerifyingAnAlienDictionary solution = new VerifyingAnAlienDictionary();
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        String[] words = {"hello", "leetcode"};
        boolean expected = true;
        System.out.println(Arrays.toString(words) + " order is : " + solution.isAlienSorted(words, order) + ", expected : " + expected);

        order = "worldabcefghijkmnpqstuvxyz";
        words = new String[]{"word", "world", "row"};
        expected = false;
        System.out.println(Arrays.toString(words) + " order is : " + solution.isAlienSorted(words, order) + ", expected : " + expected);


        order = "qcipyamwvdjtesbghlorufnkzx";
        words = new String[]{"app", "kwh"};
        expected = true;
        System.out.println(Arrays.toString(words) + " order is : " + solution.isAlienSorted(words, order) + ", expected : " + expected);

        order = "abcdefghijklmnopqrstuvwxyz";
        words = new String[]{"app", "apple"};
        expected = true;
        System.out.println(Arrays.toString(words) + " order is : " + solution.isAlienSorted(words, order) + ", expected : " + expected);

    }

    public boolean isAlienSorted(String[] words, String order) {


        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!this.compareWords(words[i], words[j], order)) {
                    return false;
                }
            }

        }
        return true;
    }

    private boolean compareWords(String word1, String word2, String order) {
        // System.out.println("Comparing " + word1 + " and " + word2);

        int maxLength = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLength; i++) {
            Character a = (i) < word1.length() ? word1.charAt(i) : null;
            Character b = (i) < word2.length() ? word2.charAt(i) : null;
            if (a == null) {
                //System.out.println(a + " in " + word1 + " or " + b + " in " + word2 + " is null");
                return true;
            } else if (b == null) {
                System.out.println(a + " in " + word1 + " or " + b + " in " + word2 + " is null");
                return false;
            } else if (order.indexOf(a) < order.indexOf(b) && !a.equals(b)) {
                return true;
            } else if (order.indexOf(a) > order.indexOf(b)) {
                System.out.println(a + " in " + word1 + " is > than " + b + " in " + word2 + " on order " + order);
                return false;
            }
        }

        return true;
    }
}
