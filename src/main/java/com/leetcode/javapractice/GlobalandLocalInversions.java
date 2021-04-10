package com.leetcode.javapractice;

public class GlobalandLocalInversions {

    public static boolean isIdealPermutation(int[] A) {
        int cmax = 0;
        for (int i = 0; i < A.length - 2; i++) {
            cmax = Math.max(cmax, A[i]);
            if (cmax > A[i + 2]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[] A = {1, 0, 2};
        System.out.println(isIdealPermutation(A));
    }
}
