package com.leetcode.javapractice;

public class SquirrelSimulation {

    public static int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int tot_dist = 0, d = Integer.MIN_VALUE;
        for (int[] nut : nuts) {
            tot_dist += (distance(nut, tree) * 2);
            d = Math.max(d, distance(nut, tree) - distance(nut, squirrel));
        }
        return tot_dist - d;
    }

    public static int distance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) {

        int[] tree = {2, 2};
        int[] squirrel = {4, 4};
        int[][] nuts = {{3, 0}, {2, 5}};
        System.out.println(minDistance(5, 7, tree, squirrel, nuts));
    }
}
