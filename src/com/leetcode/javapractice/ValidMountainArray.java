package com.leetcode.javapractice;

public class ValidMountainArray {

    public static boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            if (A[start] < A[start + 1]) {
                start++;
            } else {
                break;
            }
        }
        if (start == end || start == 0) {
            return false;
        }
        while (end > start) {
            if (A[end] < A[end - 1]) {
                end--;
            } else {
                break;
            }
        }
        return start == end;
    }

    public static void main(String[] args) {

        int[] A = { 0, 3, 2, 1 };
        System.out.println(validMountainArray(A));

    }

}
