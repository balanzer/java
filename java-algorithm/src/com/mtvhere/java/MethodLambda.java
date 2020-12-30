package com.mtvhere.java;

import java.util.function.Function;
import java.util.function.IntFunction;

public class MethodLambda {
    public static void main(final String args[]) {

        final IntFunction<String> intToString = Integer::toString;

        System.out.println("intToString : " + "4".equals(intToString.apply(3)));

        final Function<String, char[]> toChars = String::toCharArray;

        System.out.println("toChars : " + toChars.apply("Hello World").length);

    }
}
