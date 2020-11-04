package com.leetcode.javapractice;

public class ValidNumber {

    public static boolean isNumber(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        boolean seenNum = false;
        boolean seenE = false;
        boolean seenD = false;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '.':
                    if (seenD || seenE) {
                        return false;
                    }
                    seenD = true;
                    break;
                case 'e':
                    if (seenE || !seenNum) {
                        return false;
                    }
                    seenE = true;
                    seenNum = false;
                    break;
                case '+':
                case '-':
                    if (i != 0 && s.charAt(i - 1) != 'e') {
                        return false;
                    }
                    seenNum = false;
                    break;
                default:
                    if (c - '0' < 0 || c - '0' > 9) {
                        return false;
                    }
                    seenNum = true;
            }
        }
        return seenNum;
    }

    public static void main(String[] args) {

        System.out.println(isNumber("0"));
    }
}