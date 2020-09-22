package com.leetcode.javapractice;

public class MaximumXORofTwoNumbersinanArray {

    public static int findMaximumXOR(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                max = Math.max(max, xor);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }
}
