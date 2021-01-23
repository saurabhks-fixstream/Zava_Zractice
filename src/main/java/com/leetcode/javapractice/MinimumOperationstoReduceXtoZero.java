package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationstoReduceXtoZero {

    public static int minOperations(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        if (target == 0) {
            return nums.length;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 4, 2, 3};
        System.out.println(minOperations(nums, 5));
    }
}
