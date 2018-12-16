package com.leetcode.javapractice;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[j--] = nums1[m--];
            } else {
                nums1[j--] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[j--] = nums2[n--];
        }
    }

    public static void main(String[] args) {

        int[] nums1 = new int[11];
        int[] nums2 = new int[6];
        nums1[0] = -1;
        nums1[1] = 0;
        nums1[2] = 0;
        nums1[3] = 0;
        nums1[4] = 3;
        nums2[0] = -1;
        nums2[1] = -1;
        nums2[2] = 0;
        nums2[3] = 0;
        nums2[4] = 1;
        nums2[5] = 2;
        int m = 5;
        int n = 6;
        merge(nums1, m, nums2, n);
        System.out.print("[");
        for (int i : nums1) {
            System.out.print(i + ", ");
        }
        System.out.println("]");

    }

}
