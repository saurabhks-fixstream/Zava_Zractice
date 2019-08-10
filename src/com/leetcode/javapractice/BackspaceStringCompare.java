package com.leetcode.javapractice;

import java.util.Stack;

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    private static String build(String str) {
        Stack<Character> stack = new Stack<Character>();
        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    public static void main(String[] args) {

        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));

    }

}
