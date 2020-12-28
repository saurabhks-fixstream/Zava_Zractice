package com.leetcode.javapractice;

public class DecodedStringatIndex {

    public static String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();
        String result = null;
        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                size *= c - '0';
            } else {
                size++;
            }
        }
        for (int i = N - 1; i >= 0; i--) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c)) {
                result = Character.toString(c);
                break;
            }
            if (Character.isDigit(c)) {
                size /= c - '0';
            } else {
                size--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(decodeAtIndex("leet2code3", 10));
    }
}
