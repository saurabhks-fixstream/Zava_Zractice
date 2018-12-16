package com.leetcode.JavaPractice;

import java.util.HashMap;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int majority = Integer.MIN_VALUE;
        int element = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], (map.get(nums[i]) + 1));
            }
        }
        for (int i : map.keySet()) {
            int value = map.get(i);
            if (value >= majority) {
                majority = value;
                element = i;
            }
        }
        return element;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 1, 1, 1, 3, 3, 4, 4, 3, 2, 2, 2, 4, 5, 5 };
        System.out.println(majorityElement(nums));

    }

}
