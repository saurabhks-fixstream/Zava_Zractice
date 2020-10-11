package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        Set<Character> seen = new HashSet<Character>();
        HashMap<Character, Integer> last_occurrence = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            last_occurrence.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen.contains(c)) {
                while (!stack.isEmpty() && c < stack.peek() && last_occurrence.get(stack.peek()) > i) {
                    seen.remove(stack.pop());
                }
                seen.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(removeDuplicateLetters("bcabc"));
    }
}
