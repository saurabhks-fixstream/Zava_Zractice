package com.leetcode.javapractice;

public class MedianofTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums3 = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            } else {
                nums3[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums3[k++] = nums1[i++];
        }
        while (j < n) {
            nums3[k++] = nums2[j++];
        }
        if (k % 2 != 0) {
            return nums3[k / 2];
        } else {
            return (nums3[(k / 2)] + nums3[(k / 2) - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 6, 9, 11};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

}
