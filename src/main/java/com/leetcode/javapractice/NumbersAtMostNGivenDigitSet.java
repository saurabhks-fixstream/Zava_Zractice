package com.leetcode.javapractice;

public class NumbersAtMostNGivenDigitSet {

    public static int atMostNGivenDigitSet(String[] digits, int n) {
        String S = String.valueOf(n);
        int K = S.length();
        int[] dp = new int[K + 1];
        dp[K] = 1;
        for (int i = K - 1; i >= 0; i--) {
            int Si = S.charAt(i) - '0';
            for (String d : digits) {
                if (Integer.parseInt(d) < Si) {
                    dp[i] += Math.pow(digits.length, K - i - 1);
                } else if (Integer.parseInt(d) == Si) {
                    dp[i] += dp[i + 1];
                }
            }
        }
        for (int i = 1; i < K; ++i) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }

    public static void main(String[] args) {

        String[] digits = {"1", "3", "5", "7"};
        System.out.println(atMostNGivenDigitSet(digits, 100));
    }
}
