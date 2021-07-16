package com.leetcode.javapractice;

public class CustomSortString {

    public static String customSortString(String order, String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(customSortString("cba", "abcd"));
    }
}
