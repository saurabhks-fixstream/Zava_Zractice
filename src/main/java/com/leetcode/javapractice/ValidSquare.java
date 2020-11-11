package com.leetcode.javapractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidSquare {

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.addAll(
                Arrays.asList(
                        distance(p1, p2),
                        distance(p1, p3),
                        distance(p1, p4),
                        distance(p2, p3),
                        distance(p2, p4),
                        distance(p3, p4)));
        return !set.contains(0) && set.size() == 2;
    }

    private static int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    public static void main(String[] args) {

        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};
        System.out.println(validSquare(p1, p2, p3, p4));
    }
}
