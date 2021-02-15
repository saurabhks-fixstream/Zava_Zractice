package com.leetcode.javapractice;

import java.util.PriorityQueue;

public class TheKWeakestRowsinaMatrix {

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] result = new int[k];
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] {numOnes(mat[i]), i});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (k > 0) {
            result[--k] = pq.poll()[1];
        }
        return result;
    }

    private static int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (row[mid] == 1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}
        };
        int[] nums = kWeakestRows(matrix, 3);
        System.out.print("[");
        for (int i : nums) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
}
