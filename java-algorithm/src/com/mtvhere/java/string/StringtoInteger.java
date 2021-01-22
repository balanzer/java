package com.mtvhere.java.string;

public class StringtoInteger {
    public static void main(final String[] args) {
        final StringtoInteger solution = new StringtoInteger();
        String s = "42";
        System.out.println(s + " String to int : " + StringtoInteger.myAtoi(s));
        s = "   -42";
        System.out.println(s + " String to int : " + StringtoInteger.myAtoi(s));
        s = "4193 with words";
        System.out.println(s + " String to int : " + StringtoInteger.myAtoi(s));
        s = "words and 987";
        System.out.println(s + " String to int : " + StringtoInteger.myAtoi(s));
        s = "-91283472332";
        System.out.println(s + " String to int : " + StringtoInteger.myAtoi(s));
    }

    public static int myAtoi(final String s) {

        if (s != null) {
            int negate = 1;//intial
            StringBuilder number = new StringBuilder("");

            for (int i = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                if (c == ' ') {
                    //ignore space
                } else if (c == '-' || c == '+') {
                    if (c == '-') {
                        negate = -1;
                    }
                    //ignore for now
                } else if (c >= '0' && c <= '9') {
                    //valid chars
                    number = number.append(c);
                } else {
                    //invalid chars
                    break;
                }
            }


            long rangeNum = 0;
            try {
                rangeNum = Long.parseLong(number.toString());
            } catch (final NumberFormatException numExp) {
                //ignore num is already 0;
            }

            System.out.println("Final num is : " + rangeNum);

            if (rangeNum < Integer.MIN_VALUE) {
                return negate * Integer.MIN_VALUE;
            }
            if (rangeNum > Integer.MAX_VALUE) {
                return negate * Integer.MAX_VALUE;
            } else {
                return negate * Integer.parseInt("" + rangeNum);
            }
        }
        return 0;

    }
}
