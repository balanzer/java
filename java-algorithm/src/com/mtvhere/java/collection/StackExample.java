package com.mtvhere.java.collection;

import java.util.HashMap;
import java.util.Stack;
import java.util.stream.IntStream;

public class StackExample {
    public static void main(final String[] args) {
        final Stack stack = new Stack();

        IntStream.range(20, 40).forEach(num -> stack.push(num));

        //System.out.println(stack);

        while (!stack.isEmpty()) {

            final Integer item = (Integer) stack.pop();
            //System.out.println("Item : " + item);
        }
        final String[] s = {"{[()]}", "{}()", "{(})", ")", "{{[[(())]]}}", "{[(])}"};
        //final String[] s = {"{}()"};
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i] + " isBalanced : " + isBalanced(s[i]));
        }

    }

    static HashMap<Character, Character> matching = new HashMap<>();

    static {
        matching.put('[', ']');
        matching.put('{', '}');
        matching.put('(', ')');
    }

    static boolean isBalanced(final String s) {

        if (null != s && s.trim().length() > 0 && s.trim().length() % 2 == 0) {
            final Stack<Character> stack = new Stack<Character>();
            s.toCharArray();
            for (int i = 0; i < s.length(); i++) {
                final Character currentChar = s.charAt(i);
                if (stack.size() > 0) {
                    final Character lastItem = stack.peek();

                    if (matching.containsKey(lastItem)) {
                        if (matching.get(lastItem).equals(currentChar)) {
                            //matching brakcets - pop last time and do not insert current item.
                            stack.pop();
                        } else {
                            stack.push(currentChar);
                        }
                    } else {
                        //Invalid matching - not balanced
                        return false;
                    }
                } else {
                    stack.push(currentChar);
                }

                // System.out.println(stack);

            }
            return true;
        }
        return false;
    }

}
