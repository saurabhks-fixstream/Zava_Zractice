package com.leetcode.javapractice;

public class NQueensII {

    static int result = 0;

    public static int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        totalNQueensHelper(board, 0);
        return result;
    }

    private static void totalNQueensHelper(char[][] board, int row) {
        if (row == board.length) {
            result++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[row][i] = 'Q';
            if (valid(board, row, i)) {
                totalNQueensHelper(board, row + 1);
            }
            board[row][i] = '.';
        }
    }

    private static boolean valid(char[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((j == column || Math.abs(row - i) == Math.abs(column - j)) && board[i][j] == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(totalNQueens(4));
    }
}
