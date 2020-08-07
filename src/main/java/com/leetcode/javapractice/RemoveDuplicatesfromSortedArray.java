package com.leetcode.javapractice;

public class RemoveDuplicatesfromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[slow]) {
                slow++;
                nums[slow] = nums[i];
            }
        }
        return slow + 1;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2};
        int length = removeDuplicates(nums);
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ,");
        }
        System.out.println("]");
    }
}
