package com.mtvhere.java.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        String input = "";
        boolean output = solution.isValid(input);
        System.out.println(input + " has valid parentheses : " + output);

        input = "()";
        output = solution.isValid(input);
        System.out.println(input + " has valid parentheses : " + output);

        input = "()[]{}";
        output = solution.isValid(input);
        System.out.println(input + " has valid parentheses : " + output);

        input = "(]";
        output = solution.isValid(input);
        System.out.println(input + " has valid parentheses : " + output);

        input = "([)]";
        output = solution.isValid(input);
        System.out.println(input + " has valid parentheses : " + output);

        input = "{[]}";
        output = solution.isValid(input);
        System.out.println(input + " has valid parentheses : " + output);

    }

    static Map<Character, Character> parenthesesMap = new HashMap<>();

    static {
        parenthesesMap.put(')', '(');
        parenthesesMap.put('}', '{');
        parenthesesMap.put(']', '[');
    }

    public boolean isValid(String s) {

        if (s.trim().length() > 0) {

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (stack.size() == 0) {
                    stack.push(s.charAt(i));
                } else {
                    Character current = s.charAt(i);
                    if (parenthesesMap.containsKey(current)) {
                        Character last = stack.pop();
                        if (!parenthesesMap.get(current).equals(last)) {
                            return false;
                        }
                    } else {
                        stack.push(s.charAt(i));
                    }
                }
            }
            //System.out.println(stack);
            if (stack.size() == 0) {
                return true;
            }
            return false;
        }

        return true;
    }
}
