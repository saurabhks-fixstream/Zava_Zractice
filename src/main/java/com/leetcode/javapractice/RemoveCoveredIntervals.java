package com.leetcode.javapractice;

import java.util.Arrays;

public class RemoveCoveredIntervals {

    public static int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 0;
        int end = 0;
        int prev_end = 0;
        for (int[] curr : intervals) {
            end = curr[1];
            if (prev_end < end) {
                count++;
                prev_end = end;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(removeCoveredIntervals(intervals));
    }
}
