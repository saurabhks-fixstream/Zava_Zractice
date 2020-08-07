package com.leetcode.javapractice;

public class ToLowerCase {

    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                chars[i] = (char) (chars[i] - 'A' + 'a');
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {

        System.out.println(toLowerCase("Hello World"));
    }
}
