package com.leetcode.javapractice;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int left = 0;
        int right = n - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (left == n - 1 || nums[left] > nums[left + 1]) ? left : right;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1};
        System.out.println(findPeakElement(nums));
    }
}
