package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                set.add(nums[i]);
            }
        }
        int result = 0;
        while (!set.contains(result)) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 0};
        System.out.println(firstMissingPositive(nums));
    }
}
