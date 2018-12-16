package com.leetcode.javapractice;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (max <= sum) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = { -2, -1, -3 };
        System.out.println(maxSubArray(nums));

    }

}
