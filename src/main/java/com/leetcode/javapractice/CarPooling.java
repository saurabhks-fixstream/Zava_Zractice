package com.leetcode.javapractice;

import java.util.Map;
import java.util.TreeMap;

public class CarPooling {

    public static boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
        for (int[] t : trips) {
            m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);
            m.put(t[2], m.getOrDefault(t[2], 0) - t[0]);
        }
        for (int v : m.values()) {
            capacity -= v;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        System.out.println(carPooling(trips, 4));
    }
}
