package com.leetcode.javapractice;

public class CountSquareSubmatriceswithAllOnes {

    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        for (int s = 0; s <= (m < n ? m : n); s++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (validSquare(matrix, i, j, i + s, j + s, m, n)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean validSquare(int[][] matrix, int i, int j, int k, int l, int m, int n) {
        if (k >= m || l >= n) {
            return false;
        }
        for (int o = i; o <= k; o++) {
            for (int p = j; p <= l; p++) {
                if (matrix[o][p] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] matrix = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(countSquares(matrix));
    }
}
