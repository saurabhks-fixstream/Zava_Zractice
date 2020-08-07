package com.leetcode.javapractice;

public class ReverseWordsinaString {

    public static String reverseWords(String s) {
        String[] tokens = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = tokens.length - 1; i >= 0; i--) {
            if (!tokens[i].isEmpty()) {
                sb.append(tokens[i]);
                if (i > 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(reverseWords("a good   example"));
    }
}
