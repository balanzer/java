package com.mtvhere.java.collection;

import java.util.Stack;
import java.util.stream.IntStream;

public class StackExample {
    public static void main(final String[] args) {
        final Stack stack = new Stack();

        IntStream.range(20, 40).forEach(num -> stack.push(num));

        System.out.println(stack);

        while (!stack.isEmpty()) {

            final Integer item = (Integer) stack.pop();
            System.out.println("Item : " + item);
        }

    }
}
