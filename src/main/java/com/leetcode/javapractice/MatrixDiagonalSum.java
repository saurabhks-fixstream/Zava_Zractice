package com.leetcode.javapractice;

public class MatrixDiagonalSum {

    public static int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - i - 1];
        }
        return n % 2 == 0 ? sum : sum - mat[n / 2][n / 2];
    }

    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(diagonalSum(mat));
    }
}
