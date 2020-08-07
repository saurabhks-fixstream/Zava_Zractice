package com.leetcode.javapractice;

public class ToeplitzMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        int count = 0;
        if (m - 1 == 0 && n - 1 == 0) {
            return true;
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (matrix[j][i] == matrix[j + 1][i + 1]) {
                    count++;
                }
            }
        }
        if (count == ((m - 1) * (n - 1))) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] matrix1 = new int[][]{{1, 2}, {2, 2}};
        int[][] matrix2 = new int[][]{{57, 54}, {84, 57}};
        System.out.println(isToeplitzMatrix(matrix));
        System.out.println(isToeplitzMatrix(matrix1));
        System.out.println(isToeplitzMatrix(matrix2));

    }

}
