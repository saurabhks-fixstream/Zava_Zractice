package com.leetcode.javapractice;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return target - diff;
    }

    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
