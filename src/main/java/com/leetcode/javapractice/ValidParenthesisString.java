package com.leetcode.javapractice;

public class ValidParenthesisString {

    public static boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                high--;
                low = Math.max(low - 1, 0);
            } else {
                high++;
                low = Math.max(low - 1, 0);
            }
            if (high < 0) {
                return false;
            }
        }
        return low == 0;
    }

    public static void main(String[] args) {

        System.out.println(checkValidString("()"));
    }
}
