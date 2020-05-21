package com.leetcode.javapractice;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int i;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i >= 0) {
            int x = nums[i];
            int index = i + 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > x && nums[j] <= nums[index]) {
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
        reverse(nums, i + 1);
    }

    private static void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2 };
        nextPermutation(nums);
        for (int r : nums) {
            System.out.print(r + " ");
        }

    }

}
