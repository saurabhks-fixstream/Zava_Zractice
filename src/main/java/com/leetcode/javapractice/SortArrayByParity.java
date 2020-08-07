package com.leetcode.javapractice;

public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            if (A[start] % 2 != 0 && A[end] % 2 == 0) {
                swap(A, start, end);
                start++;
                end--;
            } else if (A[start] % 2 == 0) {
                start++;
            } else if (A[end] % 2 != 0) {
                end--;
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

        int[] A = {3, 1, 2, 4};
        sortArrayByParity(A);
        for (int i : A) {
            System.out.print(i + ",");
        }
    }
}
