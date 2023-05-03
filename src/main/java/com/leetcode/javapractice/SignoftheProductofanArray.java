package com.leetcode.javapractice;

public class SignoftheProductofanArray {
    public static int arraySign(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                count++;
            }
        }
        return count % 2 == 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        System.out.print(arraySign(nums));
    }
}
