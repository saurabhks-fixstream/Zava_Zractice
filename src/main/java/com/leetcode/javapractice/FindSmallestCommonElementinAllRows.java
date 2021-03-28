package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindSmallestCommonElementinAllRows {

    public static int smallestCommonElement(int[][] mat) {
        int result = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                map.put(mat[i][j], map.getOrDefault(mat[i][j], 0) + 1);
            }
        }
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == mat.length) {
                result = Math.min(entry.getKey(), result);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] mat = {{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}};
        System.out.println(smallestCommonElement(mat));
    }
}
