package com.leetcode.javapractice;

public class SingleNumberII {

    public static int singleNumber(int[] nums) {
        int x1 = 0;
        int x2 = 0;
        int mask = 0;
        for (int num : nums) {
            x2 ^= x1 & num;
            x1 ^= num;
            mask = ~(x1 & x2);
            x1 &= mask;
            x2 &= mask;
        }
        return x1;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 2};
        System.out.println(singleNumber(nums));
    }
}
