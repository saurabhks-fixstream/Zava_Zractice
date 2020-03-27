package com.leetcode.javapractice;

public class ProductofArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] newNums = new int[nums.length];
        newNums[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            newNums[i] = newNums[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            newNums[i] = newNums[i] * R;
            R *= nums[i];
        }
        return newNums;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 0 };
        int[] result = productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

}
