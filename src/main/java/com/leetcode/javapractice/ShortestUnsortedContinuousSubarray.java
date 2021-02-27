package com.leetcode.javapractice;

public class ShortestUnsortedContinuousSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - i - 1]);
            if (nums[i] < max) {
                end = i;
            }
            if (nums[len - i - 1] > min) {
                start = len - i - 1;
            }
        }
        if (start == -1) {
            return 0;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {

        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));
    }
}
