package com.mtvhere.java;

import java.util.function.*;

public class FunctionalInterfaceExamples {
    public static void main(final String[] args) {


        final String[] strValues = {"App", "Hello", "My Test", "NTZ", null, ""};

        /**
         Predicate
         */
        final Predicate<String> stringVowelsCheck = (val) -> {
            final Character[] checkFor = {'a', 'e', 'i', 'o', 'u'};
            if (val != null && val.trim().length() > 0) {

                for (final Character item : checkFor) {
                    if (val.toLowerCase().contains(item.toString())) {
                        return true;
                    }
                }
            }
            return false;
        };


        for (final String val : strValues) {
            System.out.println("Input (" + val + ") volwels Check Predicate Result: " + stringVowelsCheck.test(val));
        }

        /**
         * Consumer
         */

        final Consumer<String> consumeValue = (val) -> {
            if (val != null && val.trim().length() > 0) {
                System.out.println("Input " + val + " Consumed.");
            } else {
                System.out.println("Invalid input " + val + ", Cannot Consume");
            }
        };

        for (final String val : strValues) {
            //System.out.println("Input (" + val + ") for consumeValue");
            consumeValue.accept(val);
        }


        /**
         * Functions
         */

        final Function<String, Integer> findLength = (val) -> {
            if (val != null && val.trim().length() > 0) {
                return val.length();
            }
            return null;
        };

        for (final String val : strValues) {
            System.out.println("Input (" + val + ") length is : " + findLength.apply(val));

        }


        /**
         * Supplier
         */

        final Supplier<Double> generateRandomNumber = () -> {
            return Math.random();
        };

        System.out.println("Random Number 1 : " + generateRandomNumber.get());
        System.out.println("Random Number 2 : " + generateRandomNumber.get());
        System.out.println("Random Number 3 : " + generateRandomNumber.get());

        /**
         * Binary Operator
         */

        final BinaryOperator<Integer> multiply = (val1, val2) -> {
            return val1 * val2;
        };
        System.out.println("Binary Operation Product  : " + multiply.apply(5, 10));


        /**
         * Unary Operator
         */

        final UnaryOperator<String> trimAndConvertCase = (val) -> {
            if (null != val) {
                return val.trim().toLowerCase();
            }
            return "";
        };

        for (final String val : strValues) {
            System.out.println("Input (" + val + ") Trim And Convert Case : " + trimAndConvertCase.apply(val));
        }

    }
}
