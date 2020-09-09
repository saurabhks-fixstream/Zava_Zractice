package com.leetcode.javapractice;

public class ImageOverlap {

    public static int largestOverlap(int[][] A, int[][] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                max = Math.max(max, largestOverlapHelper(i, j, A, B));
                max = Math.max(max, largestOverlapHelper(i, j, B, A));
            }
        }
        return max;
    }

    private static int largestOverlapHelper(int row, int col, int[][] A, int[][] B) {
        int count = 0;
        int x = 0;
        for (int i = row; i < A.length; i++) {
            int y = 0;
            for (int j = col; j < A[i].length; j++) {
                if (A[i][j] == 1 && A[i][j] == B[x][y]) {
                    count++;
                }
                y++;
            }
            x++;
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] A = {{1, 1, 0}, {0, 1, 0}, {0, 1, 0}};
        int[][] B = {{0, 0, 0}, {0, 1, 1}, {0, 0, 1}};
        System.out.println(largestOverlap(A, B));
    }
}
