package com.leetcode.javapractice;

import java.util.Map.Entry;
import java.util.TreeMap;

public class FindRightInterval {

    public static int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }
        for (int i = 0; i < intervals.length; i++) {
            Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i][1]);
            result[i] = entry == null ? -1 : entry.getValue();
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] intervals = {{1, 2}};
        int[] result = findRightInterval(intervals);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
