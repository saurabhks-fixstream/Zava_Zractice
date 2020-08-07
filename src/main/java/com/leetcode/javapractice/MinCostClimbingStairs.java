package com.leetcode.javapractice;

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length < 2) {
            return 0;
        }
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (i == cost.length ? 0 : cost[i]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {

        int[] cost = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost));
    }
}
