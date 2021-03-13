package com.leetcode.javapractice;

public class RemovePalindromicSubsequences {

    public static int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return s.equals(new StringBuilder(s).reverse().toString()) ? 1 : 2;
    }

    public static void main(String[] args) {

        System.out.println(removePalindromeSub("ababa"));
    }
}
