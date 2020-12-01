package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheSkylineProblem {

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (n == 0) {
            return output;
        }
        if (n == 1) {
            int xStart = buildings[0][0];
            int xEnd = buildings[0][1];
            int y = buildings[0][2];
            output.add(Arrays.asList(xStart, y));
            output.add(Arrays.asList(xEnd, 0));
            return output;
        }
        List<List<Integer>> leftSkyline;
        List<List<Integer>> rightSkyline;
        leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
        rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));
        return mergeSkylines(leftSkyline, rightSkyline);
    }

    public static List<List<Integer>> mergeSkylines(
            List<List<Integer>> left, List<List<Integer>> right) {
        int nL = left.size();
        int nR = right.size();
        int pL = 0;
        int pR = 0;
        int currY = 0;
        int leftY = 0;
        int rightY = 0;
        int x;
        int maxY;
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        while ((pL < nL) && (pR < nR)) {
            List<Integer> pointL = left.get(pL);
            List<Integer> pointR = right.get(pR);
            if (pointL.get(0) < pointR.get(0)) {
                x = pointL.get(0);
                leftY = pointL.get(1);
                pL++;
            } else {
                x = pointR.get(0);
                rightY = pointR.get(1);
                pR++;
            }
            maxY = Math.max(leftY, rightY);
            if (currY != maxY) {
                updateOutput(output, x, maxY);
                currY = maxY;
            }
        }
        appendSkyline(output, left, pL, nL, currY);
        appendSkyline(output, right, pR, nR, currY);
        return output;
    }

    public static void updateOutput(List<List<Integer>> output, int x, int y) {
        if (output.isEmpty() || output.get(output.size() - 1).get(0) != x)
            output.add(Arrays.asList(x, y));
        else {
            output.get(output.size() - 1).set(1, y);
        }
    }

    public static void appendSkyline(
            List<List<Integer>> output, List<List<Integer>> skyline, int p, int n, int currY) {
        while (p < n) {
            List<Integer> point = skyline.get(p);
            int x = point.get(0);
            int y = point.get(1);
            p++;
            if (currY != y) {
                updateOutput(output, x, y);
                currY = y;
            }
        }
    }

    public static void main(String[] args) {

        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkyline(buildings));
    }
}
