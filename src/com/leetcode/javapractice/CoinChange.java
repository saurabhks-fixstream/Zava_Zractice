package com.leetcode.javapractice;

public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] table = new int[amount + 1];
        table[0] = 0;
        for (int i = 1; i <= amount; i++) {
            table[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int subcount = table[i - coins[j]];
                    if (subcount != Integer.MAX_VALUE && table[i] > subcount + 1) {
                        table[i] = subcount + 1;
                    }
                }
            }
        }
        if (table[amount] != Integer.MAX_VALUE) {
            return table[amount];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {

        int[] coins = { 186, 419, 83, 408 };
        int amount = 6249;
        System.out.println(coinChange(coins, amount));

    }

}