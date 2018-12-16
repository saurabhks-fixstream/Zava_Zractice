package com.leetcode.JavaPractice;

public class ReverseString {

    public static String reverseString(String s) {
        StringBuilder S = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            S.append(s.charAt(i));
        }
        return S.toString();
    }

    public static void main(String[] args) {

        System.out.println(reverseString("hello"));

    }

}
