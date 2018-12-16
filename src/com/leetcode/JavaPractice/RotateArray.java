package com.leetcode.JavaPractice;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            while (k >= nums.length) {
                k -= nums.length;
            }
        }
        k = Math.abs(nums.length - k);
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (k == nums.length) {
                k = 0;
            }
            arr[i] = nums[k++];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3 };
        int k = 4;
        rotate(nums, k);
        System.out.print("[");
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println("]");

    }

}
