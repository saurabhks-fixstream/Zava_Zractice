package com.leetcode.javapractice;

public class MinimumFallingPathSum {

    public static int minFallingPathSum(int[][] A) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int upLeft = A[i - 1][j == 0 ? 0
                        : j - 1]
                        + A[i][j];
                int up = A[i - 1][j] + A[i][j];
                int upRight = A[i - 1][j == n - 1 ? j
                        : j + 1]
                        + A[i][j];
                A[i][j] = Math.min(upLeft, Math.min(up, upRight));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, A[n - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {

        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(minFallingPathSum(A));

    }

}
