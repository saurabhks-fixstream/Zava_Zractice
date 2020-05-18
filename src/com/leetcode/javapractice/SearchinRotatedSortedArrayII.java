package com.leetcode.javapractice;

public class SearchinRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                if (end != 0 && nums[end] >= nums[end - 1]) {
                    end--;
                } else {
                    start = end;
                }
            }
        }
        int rot = start;
        start = 0;
        end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int realMid = (mid + rot) % nums.length;
            if (nums[realMid] == target) {
                return true;
            }
            if (nums[realMid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        System.out.println(search(nums, 0));

    }

}
