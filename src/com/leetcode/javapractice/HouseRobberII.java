package com.leetcode.javapractice;

import java.util.Arrays;

public class HouseRobberII {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    private static int robHelper(int[] nums, int start, int end) {
        int[] newNums = Arrays.copyOfRange(nums, start, end + 1);
        int[] dp = new int[newNums.length + 1];
        dp[0] = 0;
        dp[1] = newNums[0];
        for (int i = 1; i < newNums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + newNums[i]);
        }
        return dp[newNums.length];
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));

    }

}
