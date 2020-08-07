package com.leetcode.javapractice;

public class ShortestDistancetoaCharacter {

    public static int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        int pos = -S.length();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            result[i] = i - pos;
        }
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            result[i] = Math.min(result[i], Math.abs(i - pos));
        }
        return result;
    }

    public static void main(String[] args) {

        int[] result = shortestToChar("loveleetcode", 'e');
        for (int i : result) System.out.print(i + ",");
    }
}
