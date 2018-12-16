package com.leetcode.javapractice;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int pos = -1;
        int l = 0;
        int r = nums.length - 1;
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target) {
                pos = m;
                return pos;
            }
            if (m != nums.length - 1 && target < nums[m + 1]) {
                if (target < nums[m]) {
                    pos = m;
                } else {
                    pos = m + 1;
                }
            }
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return pos;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 6, 9 };
        int target = 8;
        System.out.println(searchInsert(nums, target));

    }

}
