package com.leetcode.javapractice;

public class SortArrayByParityII {

    public static int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        int n = A.length;
        while (i < n && j < n) {
            while (i < n && A[i] % 2 == 0) {
                i += 2;
            }
            while (j < n && A[j] % 2 == 1) {
                j += 2;
            }
            if (i < n && j < n) {
                swap(A, i, j);
            }
        }
        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {

        int[] A = {4, 2, 5, 7};
        sortArrayByParityII(A);
        for (int i : A) {
            System.out.print(i + ",");
        }
    }
}
