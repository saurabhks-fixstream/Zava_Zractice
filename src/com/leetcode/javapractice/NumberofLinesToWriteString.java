package com.leetcode.javapractice;

public class NumberofLinesToWriteString {

    public static int[] numberOfLines(int[] widths, String S) {
        int total = 0;
        int line = 1;
        int width = 0;
        for (char ch : S.toCharArray()) {
            int space = 100 - total;
            if (space >= 0) {
                if (space >= widths[ch - 'a']) {
                    total += widths[ch - 'a'];
                    width += widths[ch - 'a'];
                } else {
                    line++;
                    width = widths[ch - 'a'];
                    total = widths[ch - 'a'];
                }
            }
        }
        return new int[] { line, width };
    }

    public static void main(String[] args) {

        int[] widths = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                         10, 10 };
        int[] result = numberOfLines(widths, "abcdefghijklmnopqrstuvwxyz");
        System.out.println("[" + result[0] + ", " + result[1] + "]");

    }

}
