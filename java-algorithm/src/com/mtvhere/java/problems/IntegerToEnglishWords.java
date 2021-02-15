package com.mtvhere.java.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToEnglishWords {
    public static void main(String[] args) {
        IntegerToEnglishWords solution = new IntegerToEnglishWords();

        int num = 121212;
        // int num = Integer.MAX_VALUE;
        String output = "";
        output = solution.numberToWords(num);
        System.out.println(num + " is " + output);
    }

    static Map<Integer, String> single = new LinkedHashMap<>();
    static Map<Integer, String> tenTo19 = new LinkedHashMap<>();
    static Map<Integer, String> tens = new LinkedHashMap<>();


    static {
        single.put(1, "One");
        single.put(2, "Two");
        single.put(3, "Three");
        single.put(4, "Four");
        single.put(5, "Five");
        single.put(6, "Six");
        single.put(7, "Seven");
        single.put(8, "Eight");
        single.put(9, "Nine");

        tenTo19.put(10, "Ten");
        tenTo19.put(11, "Eleven");
        tenTo19.put(12, "Twelve");
        tenTo19.put(13, "Thirteen");
        tenTo19.put(14, "Fourteen");
        tenTo19.put(15, "Fifteen");
        tenTo19.put(16, "Sixteen");
        tenTo19.put(17, "Seventeen");
        tenTo19.put(18, "Eighteen");
        tenTo19.put(19, "Nineteen");


        tens.put(2, "Twenty");
        tens.put(3, "Thirty");
        tens.put(4, "Forty");
        tens.put(5, "Fifty");
        tens.put(6, "Sixty");
        tens.put(7, "Seventy");
        tens.put(8, "Eighty");
        tens.put(9, "Ninety");


        tens.put(2, "Twenty");
        tens.put(3, "Thirty");
        tens.put(4, "Forty");
        tens.put(5, "Fifty");
        tens.put(6, "Sixty");
        tens.put(7, "Seventy");
        tens.put(8, "Eighty");
        tens.put(9, "Ninety");
    }

    static int ONE_BILLION = 1_000_000_000;
    static int ONE_MILLION = 1_000_000;
    static int ONE_THOUSAND = 1_000;
    static int ONE_HUNDRED = 100;

    public String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }
        StringBuilder output = new StringBuilder("");

        int billions = num / ONE_BILLION;
        int leftOver = num % ONE_BILLION;

        if (billions > 0) {
            output.append(single.get(billions)).append(" Billion ");
        }

        int millions = leftOver / ONE_MILLION;

        if (millions > 0) {
            output.append(this.numberToWords(millions)).append(" Million ");
        }

        leftOver = leftOver % ONE_MILLION;

        int thousands = leftOver / ONE_THOUSAND;

        if (thousands > 0) {
            output.append(this.numberToWords(thousands)).append(" Thousand ");
        }

        leftOver = leftOver % ONE_THOUSAND;

        int hundreds = leftOver / ONE_HUNDRED;

        if (hundreds > 0) {
            output.append(this.numberToWords(hundreds)).append(" Hundred ");
        }

        leftOver = leftOver % ONE_HUNDRED;

        if (leftOver < 10) {
            output.append(single.getOrDefault(leftOver, "")).append(" ");
        } else if (leftOver < 20) {
            output.append(tenTo19.get(leftOver)).append(" ");
        } else if (leftOver < 100) {
            int tenth = leftOver / 10;
            output.append(tens.get(tenth)).append(" ");
            leftOver = leftOver % 10;
            if (leftOver > 0) {
                output.append(single.getOrDefault(leftOver, "")).append(" ");
            }

        }


        return output.toString().trim();
    }
}
