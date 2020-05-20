package com.leetcode.javapractice;

import java.util.Arrays;

public class CombinationSumIV {

    public static int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        combinationSum4Helper(nums, target, memo);
        return memo[target];
    }

    private static int combinationSum4Helper(int[] nums, int target, int[] memo) {
        if (target == 0) {
            return 1;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += combinationSum4Helper(nums, target - nums[i], memo);
            }
        }
        memo[target] = result;
        return memo[target];
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3 };
        System.out.println(combinationSum4(nums, 4));

    }

}
