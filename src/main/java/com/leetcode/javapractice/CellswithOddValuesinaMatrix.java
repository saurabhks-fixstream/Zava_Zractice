package com.leetcode.javapractice;

public class CellswithOddValuesinaMatrix {

    public static int oddCells(int n, int m, int[][] indices) {
        int count = 0;
        int[][] matrix = new int[n][m];
        for (int[] index : indices) {
            int row = index[0];
            int column = index[1];
            for (int i = 0; i < m; i++) {
                matrix[row][i]++;
            }
            for (int i = 0; i < n; i++) {
                matrix[i][column]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(oddCells(2, 3, indices));
    }
}
