package com.leetcode.JavaPractice;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int length = c.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }
        int i = 0;
        while (i < length) {
            for (int j = 0; j < numRows && i < length; j++) {
                sb[j].append(c[i++]);
            }
            for (int j = numRows - 2; j >= 1 && i < length; j--) {
                sb[j].append(c[i++]);
            }
        }
        for (int j = 1; j < sb.length; j++) {
            sb[0].append(sb[j]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {

        String s = "PALPALISHIRING";
        int numRows = 5;
        System.out.println(convert(s, numRows));

    }

}
