package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberofKSumPairs {

    public static int maxOperations(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (map.containsKey(n) && map.get(n) > 0) {
                map.put(n, map.get(n) - 1);
                count++;
            } else {
                map.put(k - n, map.getOrDefault(k - n, 0) + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        System.out.println(maxOperations(nums, 5));
    }
}
