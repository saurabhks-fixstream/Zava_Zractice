package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class NumberofBoomerangs {

    private static int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }

    public static int numberOfBoomerangs(int[][] points) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (int val : map.values()) {
                result += val * (val - 1);
            }
            map.clear();
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] points = { { 0, 0 }, { 1, 0 }, { 2, 0 } };
        System.out.println(numberOfBoomerangs(points));

    }

}
