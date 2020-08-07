package com.leetcode.javapractice;

public class RunningSumof1dArray {

    public static int[] runningSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        runningSum(nums);
        for (int i : nums) {
            System.out.print(i + ",");
        }

    }

}
