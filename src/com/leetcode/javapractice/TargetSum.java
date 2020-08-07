package com.leetcode.javapractice;

import java.util.Arrays;

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] arr : memo) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return findTargetSumWaysHelper(nums, 0, 0, S, memo);
    }

    private static int findTargetSumWaysHelper(int[] nums, int index, int sum, int S, int[][] memo) {
        if (index == nums.length) {
            if (sum == S) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (memo[index][sum + 1000] != Integer.MIN_VALUE) {
                return memo[index][sum + 1000];
            }
            int add = findTargetSumWaysHelper(nums, index + 1, sum + nums[index], S, memo);
            int sub = findTargetSumWaysHelper(nums, index + 1, sum - nums[index], S, memo);
            memo[index][sum + 1000] = add + sub;
            return add + sub;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(findTargetSumWays(nums, S));

    }

}
