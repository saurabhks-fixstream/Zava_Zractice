package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class KdiffPairsinanArray {

    public static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    result++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 4, 1, 5};
        System.out.println(findPairs(nums, 2));
    }
}
