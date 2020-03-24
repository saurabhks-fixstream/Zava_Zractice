package com.leetcode.javapractice;

import java.util.Arrays;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i] <= j) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1
                                   : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = { 1, 2, 5 };
        int amount = 11;
        System.out.println(coinChange(coins, amount));

    }

}