package com.leetcode.javapractice;

public class MonotonicArray {

    public static boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                increasing = false;
                break;
            }
        }
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                decreasing = false;
                break;
            }
        }
        return increasing || decreasing;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 4, 5};
        System.out.println(isMonotonic(A));

    }

}
