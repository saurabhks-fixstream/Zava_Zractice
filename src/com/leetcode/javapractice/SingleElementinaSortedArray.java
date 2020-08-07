package com.leetcode.javapractice;

public class SingleElementinaSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        return nums[start];
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));

    }

}
