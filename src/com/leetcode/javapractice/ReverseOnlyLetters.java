package com.leetcode.javapractice;

public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int start = 0;
        int end = S.length() - 1;
        while (start <= end) {
            if (Character.isLetter(chars[start]) && Character.isLetter(chars[end])) {
                char c = chars[start];
                chars[start] = chars[end];
                chars[end] = c;
                start++;
                end--;
            } else if (!Character.isLetter(chars[start])) {
                start++;
            } else if (!Character.isLetter(chars[end])) {
                end--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {

        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));

    }

}
