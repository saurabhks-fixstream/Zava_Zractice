package com.leetcode.javapractice;

public class ReverseStringII {

    public static String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length() && (i + 2 * k) < s.length()) {
            sb.append(reverse(s.substring(i, i + k)));
            sb.append(s.substring(i + k, i + 2 * k));
            i += 2 * k;
        }
        if (s.length() - i > k) {
            sb.append(reverse(s.substring(i, i + k)));
            sb.append(s.substring(i + k, s.length()));
        } else {
            sb.append(reverse(s.substring(i, s.length())));
        }
        return sb.toString();
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(reverseStr("abcdefg", 2));

    }

}
