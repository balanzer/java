package com.mtvhere.java.problems;

import java.util.HashMap;

public class RomantoInteger {
    public static void main(String[] args) {
        RomantoInteger solution = new RomantoInteger();

        String input = "";
        int expOutput = 0;

        input = "III";
        expOutput = 3;
        System.out.println(input + " is " + solution.romanToInt(input) + ", expected output : " + expOutput);

        input = "IV";
        expOutput = 4;
        System.out.println(input + " is " + solution.romanToInt(input) + ", expected output : " + expOutput);

        input = "IX";
        expOutput = 9;
        System.out.println(input + " is " + solution.romanToInt(input) + ", expected output : " + expOutput);


        input = "LVIII";
        expOutput = 58;
        System.out.println(input + " is " + solution.romanToInt(input) + ", expected output : " + expOutput);


        input = "MCMXCIV";
        expOutput = 1994;
        System.out.println(input + " is " + solution.romanToInt(input) + ", expected output : " + expOutput);


    }

    static HashMap<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int num = 0;
        Character lastChar = ' ';
        for (int i = s.length() - 1; i >= 0; i--) {
            Character roman = s.charAt(i);

            if (map.containsKey(lastChar)) {

                int lastCharWeight = map.get(lastChar);
                int currCharWeight = map.get(roman);

                if (lastCharWeight > currCharWeight) {
                    num = num - map.get(roman);
                } else {
                    num = num + map.get(roman);
                }

            } else {
                num = num + map.get(roman);
            }
            lastChar = roman;
        }

        return num;
    }
}
