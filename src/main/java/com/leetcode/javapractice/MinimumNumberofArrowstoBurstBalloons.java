package com.leetcode.javapractice;

import java.util.Arrays;

public class MinimumNumberofArrowstoBurstBalloons {

    public static int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int[] point = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > point[1]) {
                point = points[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));
    }
}
