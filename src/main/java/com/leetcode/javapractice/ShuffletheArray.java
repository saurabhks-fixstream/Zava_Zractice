package com.leetcode.javapractice;

public class ShuffletheArray {

    public static int[] shuffle(int[] nums, int n) {
        int[] newNums = new int[2 * n];
        int i = 0;
        int j = n;
        int k = 0;
        while (j < (2 * n)) {
            newNums[k] = nums[i++];
            newNums[k + 1] = nums[j++];
            k += 2;
        }
        return newNums;
    }

    public static void main(String[] args) {

        int[] nums = {2, 5, 1, 3, 4, 7};
        int[] newNums = shuffle(nums, 3);
        for (int i : newNums) {
            System.out.print(i + ",");
        }
    }
}
