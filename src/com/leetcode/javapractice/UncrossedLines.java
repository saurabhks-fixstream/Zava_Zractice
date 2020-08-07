package com.leetcode.javapractice;

import java.util.Arrays;

public class UncrossedLines {

    public static int maxUncrossedLines(int[] A, int[] B) {
        int[][] memo = new int[A.length][B.length];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return maxUncrossedLinesHelper(A, B, 0, 0, memo);
    }

    private static int maxUncrossedLinesHelper(int[] A, int[] B, int a, int b, int[][] memo) {
        if (a >= A.length || b >= B.length) {
            return 0;
        }
        if (memo[a][b] != -1) {
            return memo[a][b];
        }
        int count = 0;
        if (A[a] == B[b]) {
            count = 1 + maxUncrossedLinesHelper(A, B, a + 1, b + 1, memo);
        } else {
            count += Math.max(maxUncrossedLinesHelper(A, B, a + 1, b, memo),
                    maxUncrossedLinesHelper(A, B, a, b + 1, memo));
        }
        memo[a][b] = count;
        return count;
    }

    public static void main(String[] args) {

        int[] A = {1, 4, 2};
        int[] B = {1, 2, 4};
        System.out.println(maxUncrossedLines(A, B));

    }

}
