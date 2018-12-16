package com.leetcode.JavaPractice;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int total = ((nums.length) * (nums.length + 1)) / 2;
        return total - sum;
    }

    public static void main(String[] args) {

        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(missingNumber(nums));

    }

}
