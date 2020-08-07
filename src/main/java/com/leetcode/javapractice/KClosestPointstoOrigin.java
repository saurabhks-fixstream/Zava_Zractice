package com.leetcode.javapractice;

import java.util.Arrays;

public class KClosestPointstoOrigin {

    public static int[][] kClosest(int[][] points, int K) {
        int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; i++) {
            dists[i] = distance(points[i]);
        }
        Arrays.sort(dists);
        int distK = dists[K - 1];
        int[][] ans = new int[K][2];
        int j = 0;
        for (int i = 0; i < N; i++) {
            if (distance(points[i]) <= distK) {
                ans[j++] = points[i];
            }
        }
        return ans;
    }

    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {

        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int K = 2;
        int[][] result = kClosest(points, K);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
