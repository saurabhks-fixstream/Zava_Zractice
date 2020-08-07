package com.leetcode.javapractice;

public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String S) {
        int i = 0;
        char[] stack = new char[S.length()];
        for (int j = 0; j < S.length(); j++) {
            if (i > 0 && stack[i - 1] == S.charAt(j)) {
                i--;
            } else {
                stack[i++] = S.charAt(j);
            }
        }
        return new String(stack, 0, i);
    }

    public static void main(String[] args) {

        System.out.println(removeDuplicates("abbaca"));
    }
}
