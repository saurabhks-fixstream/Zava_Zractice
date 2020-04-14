package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        Arrays.fill(arr, -1);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                arr[0] = i;
                arr[1] = map.get(nums[i]);
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] sum = twoSum(nums, target);
        System.out.print("[");
        for (int i : sum) {
            System.out.print(i);
            if (i != sum.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");

    }

}
