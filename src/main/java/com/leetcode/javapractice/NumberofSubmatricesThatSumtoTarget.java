package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class NumberofSubmatricesThatSumtoTarget {

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                counter.clear();
                counter.put(0, 1);
                int cur = 0;
                for (int k = 0; k < m; k++) {
                    cur += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
                    res += counter.getOrDefault(cur - target, 0);
                    counter.put(cur, counter.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(numSubmatrixSumTarget(matrix, 0));
    }
}
