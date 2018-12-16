package com.leetcode.JavaPractice;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int key = map.get(nums[i]);
            if (key > 1) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 2, 3, 4, 5, 6 };
        System.out.println(containsDuplicate(nums));

    }

}
