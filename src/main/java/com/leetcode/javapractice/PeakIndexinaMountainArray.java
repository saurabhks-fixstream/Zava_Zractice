package com.leetcode.javapractice;

public class PeakIndexinaMountainArray {

    public static int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] A = {0, 2, 1, 0};
        System.out.println(peakIndexInMountainArray(A));
    }
}
