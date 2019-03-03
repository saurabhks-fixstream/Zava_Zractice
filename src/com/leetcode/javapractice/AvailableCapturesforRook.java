package com.leetcode.javapractice;

public class AvailableCapturesforRook {

    public static int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    return capture(board, i, j, 0, 1) + capture(board, i, j, 0, -1) + capture(board, i, j, 1, 0)
                           + capture(board, i, j, -1, 0);
                }
            }
        }
        return 0;
    }

    private static int capture(char[][] b, int x, int y, int dx, int dy) {
        while (x >= 0 && x < b.length && y >= 0 && y < b[x].length && b[x][y] != 'B') {
            if (b[x][y] == 'p') {
                return 1;
            }
            x += dx;
            y += dy;
        }
        return 0;
    }

    public static void main(String[] args) {

        char[][] board = { { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
                           { '.', '.', '.', 'R', '.', '.', '.', 'p' }, { '.', '.', '.', '.', '.', '.', '.', '.' },
                           { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', 'p', '.', '.', '.', '.' },
                           { '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.' } };
        System.out.println(numRookCaptures(board));

    }

}
