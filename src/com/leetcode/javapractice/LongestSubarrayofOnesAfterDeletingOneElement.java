package com.leetcode.javapractice;

public class LongestSubarrayofOnesAfterDeletingOneElement {

    public static int longestSubarray(int[] nums) {
        int i = 0;
        int k = 1;
        int max = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }
            max = Math.max(max, j - i);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums));

    }

}
