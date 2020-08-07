package com.leetcode.javapractice;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxValue = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxValue = Math.max(maxValue, dp[j]);
                }
            }
            dp[i] = maxValue + 1;
            maxAns = Math.max(maxAns, dp[i]);
        }
        return maxAns;
    }

    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 4};
        System.out.println(lengthOfLIS(nums));
    }
}
