package com.leetcode.javapractice;

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            count = nums[i] == 0 ? 0 : count + 1;
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }
}
