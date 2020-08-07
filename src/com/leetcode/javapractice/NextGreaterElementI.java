package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int found = -1;
            if (map.containsKey(nums1[i])) {
                found = map.get(nums1[i]);
            }
            if (found == -1) {
                nums1[i] = -1;
            } else {
                int index = -1;
                for (int j = found; j < nums2.length; j++) {
                    if (nums2[j] > nums1[i]) {
                        index = j;
                        break;
                    }
                }
                if (index != -1) {
                    nums1[i] = nums2[index];
                } else {
                    nums1[i] = index;
                }
            }
        }
        return nums1;
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 1, 5, 7, 9, 2, 6};
        int[] nums2 = {1, 2, 3, 5, 6, 7, 9, 11};
        int[] nums = nextGreaterElement(nums1, nums2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

}
