package com.leetcode.javapractice;

public class StoneGameIV {

    public static boolean winnerSquareGame(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return winnerSquareGameHelper(n, memo);
    }

    private static boolean winnerSquareGameHelper(int n, Boolean[] memo) {
        if (n == 0) {
            return false;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        for (int i = 1; i * i <= n; i++) {
            if (!winnerSquareGameHelper(n - i * i, memo)) {
                return memo[n] = true;
            }
        }
        return memo[n] = false;
    }

    public static void main(String[] args) {

        System.out.println(winnerSquareGame(1));
    }
}
