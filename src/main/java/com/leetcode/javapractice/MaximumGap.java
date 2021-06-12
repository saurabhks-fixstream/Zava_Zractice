package com.leetcode.javapractice;

import java.util.Arrays;

public class MaximumGap {

    public static int maximumGap(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {3, 6, 9, 1};
        System.out.println(maximumGap(nums));
    }
}
