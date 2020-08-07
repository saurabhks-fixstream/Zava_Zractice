package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int count = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] nums = {0, 1, 0};
        System.out.println(findMaxLength(nums));
    }
}
