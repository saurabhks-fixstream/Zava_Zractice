package com.leetcode.javapractice;

import java.util.Arrays;

public class NumberofSubsequencesThatSatisfytheGivenSumCondition {

    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int start = 0;
        int end = nums.length - 1;
        int mod = (int) (1e9 + 7);
        int[] powers = new int[nums.length];
        powers[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            powers[i] = powers[i - 1] * 2 % mod;
        }
        while (start <= end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else {
                result = (result + powers[end - start]) % mod;
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3, 5, 6, 7};
        System.out.println(numSubseq(nums, 9));
    }
}
