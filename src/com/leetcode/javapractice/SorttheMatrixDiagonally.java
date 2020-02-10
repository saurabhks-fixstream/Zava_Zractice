package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SorttheMatrixDiagonally {

    public static int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = i, k = 0; j < m && k < n; j++, k++) {
                list.add(mat[j][k]);
            }
            Collections.sort(list);
            int count = 0;
            for (int j = i, k = 0; j < m && k < n; j++, k++) {
                mat[j][k] = list.get(count++);
            }
        }
        for (int i = 1; i < n; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0, k = i; j < m && k < n; j++, k++) {
                list.add(mat[j][k]);
            }
            Collections.sort(list);
            int count = 0;
            for (int j = 0, k = i; j < m && k < n; j++, k++) {
                mat[j][k] = list.get(count++);
            }
        }
        return mat;
    }

    public static void main(String[] args) {

        int[][] mat = { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } };
        diagonalSort(mat);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }

    }

}
