package com.leetcode.javapractice;

public class RangeSumQueryImmutable {

    static int[] arr;

    public static void NumArray(int[] nums) {
        arr = new int[nums.length + 1];
        arr[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
    }

    public static int sumRange(int i, int j) {
        if (i == j) {
            return arr[i + 1] - arr[i];
        } else {
            return arr[j + 1] - arr[i];
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 4, -6, 2, 4, 5, 6};
        NumArray(nums);
        System.out.println(sumRange(0, 0));
        System.out.println(sumRange(1, 2));
        System.out.println(sumRange(0, 1));
        System.out.println(sumRange(1, 1));
        System.out.println(sumRange(0, 6));

    }

}
