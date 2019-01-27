package com.leetcode.javapractice;

public class SquaresofaSortedArray {

    public static int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int start = 0;
        int end = A.length - 1;
        for (int i = A.length - 1; i >= 0; i--) {
            if (Math.abs(A[start]) > Math.abs(A[end])) {
                result[i] = A[start] * A[start];
                start++;
            } else {
                result[i] = A[end] * A[end];
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[] A = { -4, -1, 0, 3, 10 };
        A = sortedSquares(A);
        for (int a : A) {
            System.out.print(a + " ");
        }

    }

}
