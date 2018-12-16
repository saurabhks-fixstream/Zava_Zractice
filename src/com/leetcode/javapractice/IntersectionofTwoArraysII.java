package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], (map.get(nums1[i]) + 1));
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && (map.get(nums2[i]) != 0)) {
                list.add(nums2[i]);
                map.put(nums2[i], (map.get(nums2[i]) - 1));
            }
        }
        int[] nums = new int[list.size()];
        int j = 0;
        for (int i : list) {
            nums[j++] = i;
        }
        return nums;
    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 1, 1 };
        int[] nums2 = { 1, 1 };
        int[] nums = intersect(nums1, nums2);
        System.out.print("[");
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println("]");

    }

}
