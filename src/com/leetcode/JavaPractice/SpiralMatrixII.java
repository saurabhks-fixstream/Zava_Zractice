package com.leetcode.JavaPractice;

public class SpiralMatrixII {

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int r1 = 0;
        int r2 = n - 1;
        int c1 = 0;
        int c2 = n - 1;
        int num = 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                matrix[r1][c] = num;
                num++;
            }
            for (int r = r1 + 1; r <= r2; r++) {
                matrix[r][c2] = num;
                num++;
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    matrix[r2][c] = num;
                    num++;
                }
                for (int r = r2; r > r1; r--) {
                    matrix[r][c1] = num;
                    num++;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return matrix;
    }

    public static void main(String[] args) {

        int n = 0;
        int[][] matrix = generateMatrix(n);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

}
