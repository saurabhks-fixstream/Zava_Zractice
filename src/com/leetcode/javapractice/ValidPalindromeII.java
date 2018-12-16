package com.leetcode.javapractice;

public class ValidPalindromeII {

    private static boolean validPalindromeHelper(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return validPalindromeHelper(s, start + 1, end) || validPalindromeHelper(s, start, end - 1);
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("cbbcc"));
        System.out.println(validPalindrome("abc"));

    }

}
