package com.leetcode.javapractice;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] sum = twoSum(nums, target);
        System.out.print("[");
        for (int i : sum) {
            System.out.print(i);
            if (i != sum.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");

    }

}
