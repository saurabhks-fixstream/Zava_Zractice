package com.leetcode.javapractice;

public class LongestContinuousIncreasingSubsequence {

    public static int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxCount = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count >= maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(findLengthOfLCIS(nums));

    }

}
