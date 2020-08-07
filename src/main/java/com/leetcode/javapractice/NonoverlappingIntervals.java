package com.leetcode.javapractice;

import java.util.Arrays;

public class NonoverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        int count = -1;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] newInterval = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] < newInterval[1]) {
                count++;
            } else {
                newInterval = interval;
            }
        }
        return count == -1 ? 0 : count;
    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
