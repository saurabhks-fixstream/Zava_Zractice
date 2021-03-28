package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.PriorityQueue;

public class AdvantageShuffle {

    public static int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        int n = A.length;
        int[] res = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            pq.add(new int[] {B[i], i});
        }
        int lo = 0;
        int hi = n - 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int idx = cur[1];
            int val = cur[0];
            if (A[hi] > val) {
                res[idx] = A[hi--];
            } else {
                res[idx] = A[lo++];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] A = {2, 7, 11, 15};
        int[] B = {1, 10, 4, 11};
        int[] result = advantageCount(A, B);
        System.out.print("[");
        for (int i : result) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }
}
