package com.leetcode.javapractice;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int prev = -1;
        for (char c : s.toCharArray()) {
            int idx = t.indexOf(c, prev + 1);
            if (idx == -1 || idx <= prev) {
                return false;
            }
            prev = idx;
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isSubsequence("abc", "ahbgdc"));

    }

}
