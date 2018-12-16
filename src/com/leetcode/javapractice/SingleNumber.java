package com.leetcode.javapractice;

import java.util.HashMap;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.replace(nums[i], 0);
            }
        }
        for (int i : map.keySet()) {
            if (map.get(i) == 1) {
                single = i;
            }
        }
        return single;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 2, 2, 4, 4, 3, 3, 5, 5, 6, 6 };
        System.out.println(singleNumber(nums));

    }

}
