package com.mtvhere.java.map;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        RansomNote solution = new RansomNote();
        boolean expected = false;
        String ransomNote = "a";
        String magazine = "b";
        boolean output = solution.canConstruct(ransomNote, magazine);
        System.out.println("ransomNote : " + ransomNote + " on magazine : " + magazine + " is " + output + ", expected : " + expected);

        ransomNote = "aa";
        magazine = "ab";
        expected = false;
        output = solution.canConstruct(ransomNote, magazine);
        System.out.println("ransomNote : " + ransomNote + " on magazine : " + magazine + " is " + output + ", expected : " + expected);

        ransomNote = "aa";
        magazine = "aab";
        expected = true;
        output = solution.canConstruct(ransomNote, magazine);
        System.out.println("ransomNote : " + ransomNote + " on magazine : " + magazine + " is " + output + ", expected : " + expected);

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        Map<Character, Integer> ransomMap = this.getCharacterMap(ransomNote);
        Map<Character, Integer> magazineMap = this.getCharacterMap(magazine);

        if (magazineMap.keySet().size() < ransomMap.keySet().size()) {
            return false;
        }
        for (Character key : ransomMap.keySet()) {
            if (magazineMap.containsKey(key)) {

                if (magazineMap.get(key) < ransomMap.get(key)) {
                    return false;
                } else {
                    continue;
                }

            } else {
                return false;
            }

        }

        return true;
    }

    private Map<Character, Integer> getCharacterMap(String note) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < note.length(); i++) {
            char key = note.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        return map;
    }
}
