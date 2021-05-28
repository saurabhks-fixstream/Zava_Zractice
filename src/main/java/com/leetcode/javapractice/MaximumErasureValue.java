package com.leetcode.javapractice;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {

    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int start = 0;
        int end = 0;
        int sum = 0;
        int max = 0;
        while (start < nums.length && end < nums.length) {
            if (!set.contains(nums[end])) {
                sum += nums[end];
                max = Math.max(max, sum);
                set.add(nums[end++]);
            } else {
                sum -= nums[start];
                set.remove(nums[start++]);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {4, 2, 4, 5, 6};
        System.out.println(maximumUniqueSubarray(nums));
    }
}
