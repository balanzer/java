package com.mtvhere.java.problems;

import java.util.Comparator;
import java.util.HashMap;

public class IntergerToRoman {

    public static void main(String[] args) {
        IntergerToRoman solution = new IntergerToRoman();

        int input = 3;
        String expected = "III";
        System.out.println(input + " is : " + solution.intToRoman(input) + ", expected : " + expected);

        input = 4;
        expected = "IV";
        System.out.println(input + " is : " + solution.intToRoman(input) + ", expected : " + expected);

        input = 9;
        expected = "IX";
        System.out.println(input + " is : " + solution.intToRoman(input) + ", expected : " + expected);

        input = 58;
        expected = "LVIII";
        System.out.println(input + " is : " + solution.intToRoman(input) + ", expected : " + expected);

        input = 1994;
        expected = "MCMXCIV";
        System.out.println(input + " is : " + solution.intToRoman(input) + ", expected : " + expected);
    }


    static HashMap<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }


    public String intToRoman(int num) {

        if (map.containsKey(num)) {
            return map.get(num);
        }

        int closeMax = map.keySet().stream().filter(x -> x < num).max(Comparator.naturalOrder()).get();
        return map.get(closeMax) + this.intToRoman(num - closeMax);

    }
}
