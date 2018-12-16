package com.leetcode.javapractice;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int max = Integer.MAX_VALUE;
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (length >= strs[i].length()) {
                length = strs[i].length();
                max = i;
            }
        }
        for (int i = 0; i < length; i++) {
            char ch = strs[max].charAt(i);
            int count = 0;
            for (int j = 0; j < strs.length; j++) {
                if (ch == strs[j].charAt(i)) {
                    count++;
                }
            }
            if (count == strs.length) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String[] strs = { "ccba", "ccba", "ccbdd" };
        System.out.println(longestCommonPrefix(strs));

    }

}
