package com.leetcode.javapractice;

import java.util.Arrays;

public class MinimumDifferenceBetweenLargestandSmallestValueinThreeMoves {

    public static int minDifference(int[] nums) {
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        if (n < 5) {
            return 0;
        }
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            result = Math.min(result, nums[n - 4 + i] - nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = { 5, 3, 2, 4 };
        System.out.println(minDifference(nums));

    }

}
