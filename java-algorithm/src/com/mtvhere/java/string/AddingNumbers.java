package com.mtvhere.java.string;

import java.util.function.Predicate;

/**
 * using strings
 */
public class AddingNumbers {

    private boolean isValidNumber(final String num) {
        if (num != null && num.trim().length() > 0) {
            for (int i = num.length() - 1; i >= 0; i--) {
                if (num.charAt(i) < '0' || num.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String addStrings(String num1, String num2) {

        final Predicate<String> validate = s -> {
            return this.isValidNumber(s);
        };


        int maxLength = 0;

        if (validate.test(num1) && validate.test((num2))) {
            maxLength = Math.max(num1.length(), num2.length());
        }
        num1 = this.addPrefixZero(num1, maxLength);
        num2 = this.addPrefixZero(num2, maxLength);

        //System.out.println("num1 : " + num1 + ", num2 : " + num2);
        // System.out.println("Max Length : " + maxLength);

        String result = new String();
        int carry = 0;
        int sum = 0;
        for (int i = maxLength - 1; i >= 0; i--) {


            char n1 = num1.charAt(i);
            char n2 = num2.charAt(i);

            Integer number1 = Integer.parseInt("" + n1);
            Integer number2 = Integer.parseInt("" + n2);

            sum = carry + number1 + number2;
            carry = (sum - (sum % 10)) / 10;

            // System.out.println(number1 + " " + number2 + " sum : " + sum + " carry : " + carry);
            result = (sum % 10) + result;
        }
        //add final carry
        if (carry > 0) {
            result = carry + result;
        }
        // System.out.println("Result : " + result.toString());
        return result;
    }

    private String addPrefixZero(String num, int maxLength) {
        int curLength = num.length();
        StringBuilder output = new StringBuilder();
        while (curLength < maxLength) {
            output = output.append("0");
            curLength++;
        }
        return output.append(num).toString();
    }


    public static void main(final String[] args) {

        AddingNumbers solution = new AddingNumbers();

        final String num1 = "555";
        final String num2 = "555";
        final String result = solution.addStrings(num1, num2);
        System.out.println("output : " + result);

    }


}
