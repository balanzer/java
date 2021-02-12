package com.mtvhere.java.stack;

public class RansomNote {
    public static void main(String[] args) {
        com.mtvhere.java.map.RansomNote solution = new com.mtvhere.java.map.RansomNote();
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

        //sort
        //store in stack
        //pop and see char match

        return true;
    }


}
