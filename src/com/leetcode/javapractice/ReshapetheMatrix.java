package com.leetcode.javapractice;

public class ReshapetheMatrix {

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if ((row * column) != (r * c)) {
            return nums;
        }
        int m = 0;
        int n = 0;
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (n == column) {
                    m++;
                    n = 0;
                }
                result[i][j] = nums[m][n++];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] nums = { { 1, 2 }, { 3, 4 } };
        int[][] result = matrixReshape(nums, 1, 4);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

}
