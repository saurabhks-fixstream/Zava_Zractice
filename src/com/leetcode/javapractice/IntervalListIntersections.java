package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<int[]>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) {
                ans.add(new int[] { lo, hi });
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {

        int[][] A = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] B = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        int[][] result = intervalIntersection(A, B);
        System.out.print("[");
        for (int[] r : result) {
            System.out.print("[" + r[0] + "," + r[1] + "],");
        }
        System.out.println("]");

    }

}
