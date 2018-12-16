package com.leetcode.javapractice;

public class NondecreasingArray {

    public static boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int decrease = 0;
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                decrease++;
                index = i;
            }
        }
        if (decrease > 1) {
            return false;
        }
        return index == 0 || index == nums.length - 2 || nums[index - 1] <= nums[index + 1]
               || nums[index] <= nums[index + 2];
    }

    public static void main(String[] args) {

        int[] nums = { -1, 4, 2, 3 };
        System.out.println(checkPossibility(nums));

    }

}
