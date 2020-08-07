package com.leetcode.javapractice;

public class GettheMaximumScore {

    public static int maxSum(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        long a = 0;
        long b = 0;
        long mod = (long) (1e9 + 7);
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                a += nums1[i++];
            } else if (j < nums2.length && (i == nums1.length || nums1[i] > nums2[j])) {
                b += nums2[j++];
            } else {
                a = b = Math.max(a, b) + nums1[i];
                i++;
                j++;
            }
        }
        return (int) (Math.max(a, b) % mod);
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 4, 5, 8, 10};
        int[] nums2 = {4, 6, 8, 9};
        System.out.println(maxSum(nums1, nums2));
    }
}
