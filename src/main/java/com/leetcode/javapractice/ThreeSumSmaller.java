package com.leetcode.javapractice;

import java.util.Arrays;

public class ThreeSumSmaller {

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < target) {
                    count += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums = {-2, 0, 1, 3};
        System.out.println(threeSumSmaller(nums, 2));
    }
}
