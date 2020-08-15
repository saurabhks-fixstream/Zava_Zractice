package com.leetcode.javapractice;

public class ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        int num = 0;
        int exp = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            num += (s.charAt(i) - 'A' + 1) * exp;
            exp *= 26;
        }
        return num;
    }

    public static void main(String[] args) {

        System.out.println(titleToNumber("AA"));
    }
}
