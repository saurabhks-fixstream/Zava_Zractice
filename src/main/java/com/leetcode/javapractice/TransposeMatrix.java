package com.leetcode.javapractice;

public class TransposeMatrix {

    public static int[][] transpose(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = transpose(A);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
    }
}
