package com.leetcode.javapractice;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char f = Character.toLowerCase(s.charAt(start));
            if (!Character.isLetterOrDigit(f)) {
                start++;
                continue;
            }
            char l = Character.toLowerCase(s.charAt(end));
            if (!Character.isLetterOrDigit(l)) {
                end--;
                continue;
            }
            if (f != l) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
