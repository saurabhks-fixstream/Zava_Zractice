package com.leetcode.javapractice;

public class LongestPalindromicSubstring {

    private static boolean longestPalindromeHelper(String s, int start, int end) {
        if (start < 0) {
            return false;
        }
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        int start = -1;
        int currLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (longestPalindromeHelper(s, i - currLen - 1, i)) {
                start = i - currLen - 1;
                currLen += 2;
            } else if (longestPalindromeHelper(s, i - currLen, i)) {
                start = i - currLen;
                currLen += 1;
            }
        }
        return s.substring(start, start + currLen);
    }

    public static void main(String[] args) {

        System.out.println(longestPalindrome("abcabacbdef"));
    }
}
