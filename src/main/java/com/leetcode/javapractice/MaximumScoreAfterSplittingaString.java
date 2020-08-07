package com.leetcode.javapractice;

public class MaximumScoreAfterSplittingaString {

    public static int maxScore(String s) {
        int zero = 0;
        int one = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                one++;
            } else {
                zero++;
            }
            if (i != s.length() - 1) {
                max = Math.max(zero - one, max);
            }
        }
        return max + one;
    }

    public static void main(String[] args) {

        System.out.println(maxScore("0011"));
    }
}
