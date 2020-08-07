package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueensHelper(board, 0, result);
        return result;
    }

    private static void solveNQueensHelper(char[][] board, int row, List<List<String>> result) {
        if (board.length == row) {
            result.add(builder(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            board[row][i] = 'Q';
            if (valid(board, row, i)) {
                solveNQueensHelper(board, row + 1, result);
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

    private static List<String> builder(char[][] board) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            String str = new String(board[i]);
            list.add(str);
        }
        return list;
    }

    public static void main(String[] args) {

        System.out.println(solveNQueens(4));
    }
}
