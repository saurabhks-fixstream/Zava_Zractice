package com.leetcode.javapractice;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int rightSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (rightSum == sum) {
                return i;
            }
            rightSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));

    }

}
