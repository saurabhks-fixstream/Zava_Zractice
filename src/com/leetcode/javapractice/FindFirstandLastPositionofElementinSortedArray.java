package com.leetcode.javapractice;

public class FindFirstandLastPositionofElementinSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] != target) {
            return result;
        }
        result[0] = start;
        end = nums.length - 1;
        while (start < end) {
            int mid = (start + (end - start) / 2) + 1;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        result[1] = end;
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int[] result = searchRange(nums, 8);
        for (int i : result) {
            System.out.print(i + ",");
        }

    }

}
