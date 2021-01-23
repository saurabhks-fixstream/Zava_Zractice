package com.leetcode.javapractice;

import java.util.Arrays;

public class KthLargestElementinanArray {

    public static int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }
}
