package com.leetcode.javapractice;

public class LongestMountaininArray {

    public static int longestMountain(int[] A) {
        int max = 0;
        int i = 1;
        while (i < A.length) {
            while (i < A.length && A[i - 1] == A[i]) {
                i++;
            }
            int up = 0;
            while (i < A.length && A[i - 1] < A[i]) {
                up++;
                i++;
            }
            int down = 0;
            while (i < A.length && A[i - 1] > A[i]) {
                down++;
                i++;
            }
            if (up > 0 && down > 0) {
                max = Math.max(max, up + down + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] A = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestMountain(A));
    }
}
