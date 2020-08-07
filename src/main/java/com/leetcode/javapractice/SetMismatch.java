package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class SetMismatch {

    public static int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int missing = 0;
        int duplicate = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                missing = i;
            } else if (map.get(i) == 2) {
                duplicate = i;
            }
        }
        return new int[] {duplicate, missing};
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 4};
        int[] result = findErrorNums(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
