package com.leetcode.javapractice;

public class CountBinarySubstrings {

    public static int countBinarySubstrings(String s) {
        int cur = 1;
        int pre = 0;
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, pre);
    }

    public static void main(String[] args) {

        System.out.println(countBinarySubstrings("00110011"));
    }
}
