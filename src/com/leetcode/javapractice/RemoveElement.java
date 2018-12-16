package com.leetcode.javapractice;

import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                length--;
                nums[i] = Integer.MAX_VALUE;
            }
        }
        Arrays.sort(nums);
        return length;
    }

    public static void main(String[] args) {

        int[] nums = { 3, 2, 6, 3, 2, 5, 4, 6, 6, 6, 6, 6, 2, 3 };
        int val = 6;
        int length = removeElement(nums, val);
        System.out.print("[ ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println("]");

    }

}
