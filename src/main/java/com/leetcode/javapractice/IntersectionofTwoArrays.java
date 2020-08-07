package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionofTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        if (nums1.length <= nums2.length) {
            for (int i = 0; i < nums1.length; i++) {
                if (!set.contains(nums1[i])) {
                    set.add(nums1[i]);
                }
            }
            for (int i = 0; i < nums2.length; i++) {
                if (set.contains(nums2[i]) && !list.contains(nums2[i])) {
                    list.add(nums2[i]);
                }
            }
        } else {
            for (int i = 0; i < nums2.length; i++) {
                if (!set.contains(nums2[i])) {
                    set.add(nums2[i]);
                }
            }
            for (int i = 0; i < nums1.length; i++) {
                if (set.contains(nums1[i]) && !list.contains(nums1[i])) {
                    list.add(nums1[i]);
                }
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

        int[] nums1 = {1};
        int[] nums2 = {1, 1};
        int[] nums = intersection(nums1, nums2);
        System.out.print("[");
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
}
