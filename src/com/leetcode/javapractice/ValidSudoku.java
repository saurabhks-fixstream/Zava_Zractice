package com.leetcode.javapractice;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[10];
            boolean[] column = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int t = board[i][j] - '0';
                    if (column[t]) {
                        return false;
                    } else {
                        column[t] = true;
                    }
                }
                if (board[j][i] != '.') {
                    int t = board[j][i] - '0';
                    if (row[t]) {
                        return false;
                    } else {
                        row[t] = true;
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int x = i * 3;
                int y = j * 3;
                boolean[] all = new boolean[10];
                for (int k = x; k < x + 3; k++) {
                    for (int l = y; l < y + 3; l++) {
                        if (board[k][l] != '.') {
                            int t = board[k][l] - '0';
                            if (all[t]) {
                                return false;
                            } else {
                                all[t] = true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));

    }

}
