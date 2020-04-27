package com.leetcode.javapractice;

public class MaximalSquare {

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = m > 0 ? matrix[0].length
                      : 0;
        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < m && sqlen + j < n && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            sqlen++;
                        }
                    }
                    if (maxLen < sqlen) {
                        maxLen = sqlen;
                    }
                }
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {

        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                            { '1', '0', '0', '1', '0' } };
        System.out.println(maximalSquare(matrix));

    }

}
