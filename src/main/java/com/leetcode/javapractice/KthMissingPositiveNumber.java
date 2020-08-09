package com.leetcode.javapractice;

public class KthMissingPositiveNumber {

    public static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] - (mid + 1) < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start + k;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 7, 11};
        System.out.println(findKthPositive(arr, 5));
    }
}
