package com.leetcode.javapractice;

public class PrisonCellsAfterNDays {

    public static int[] prisonAfterNDays(int[] cells, int N) {
        N = (N - 1) % 14 + 1;
        for (int i = 0; i < N; i++) {
            int[] newCells = new int[8];
            for (int j = 1; j < cells.length - 1; j++) {
                newCells[j] = cells[j - 1] == cells[j + 1] ? 1
                                                           : 0;
            }
            cells = newCells;
        }
        return cells;
    }

    public static void main(String[] args) {

        int[] cells = { 0, 1, 0, 1, 1, 0, 0, 1 };
        int[] result = prisonAfterNDays(cells, 7);
        for (int i : result) {
            System.out.print(i + ", ");
        }

    }

}
