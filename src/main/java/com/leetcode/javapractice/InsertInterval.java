package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<int[]>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        ans.add(newInterval);
        while (i < intervals.length) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = insert(intervals, newInterval);
        System.out.print("[");
        for (int[] r : result) {
            System.out.print("[" + r[0] + "," + r[1] + "],");
        }
        System.out.println("]");
    }
}
