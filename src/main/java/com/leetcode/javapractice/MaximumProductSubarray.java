package com.leetcode.javapractice;

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int productMax = 1;
        int productMin = 1;
        for (int i = 0; i < nums.length; i++) {
            int prod1 = productMax * nums[i];
            int prod2 = productMin * nums[i];
            productMax = Math.max(nums[i], Math.max(prod1, prod2));
            productMin = Math.min(nums[i], Math.min(prod1, prod2));
            max = Math.max(max, productMax);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }
}
