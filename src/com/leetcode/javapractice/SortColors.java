package com.leetcode.javapractice;

public class SortColors {

    public static void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int i = 0;
        while (i <= end) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 0) {
                swap(nums, i, start);
                start++;
                i++;
            } else {
                swap(nums, i, end);
                end--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

}
