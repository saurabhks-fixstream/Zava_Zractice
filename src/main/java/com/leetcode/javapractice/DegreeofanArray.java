package com.leetcode.javapractice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray {

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        Map<Integer, Integer> right = new HashMap<Integer, Integer>();
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) {
                left.put(x, i);
            }
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }
        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int num : nums) {
            if (count.get(num) == degree) {
                ans = Math.min(ans, right.get(num) - left.get(num) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(findShortestSubArray(nums));
    }
}
