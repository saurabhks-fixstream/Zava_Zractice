package com.leetcode.javapractice;

import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalandVerticalCuts {

    public static int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxh = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int maxw = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
        for (int i = 0; i < horizontalCuts.length - 1; i++) {
            maxh = Math.max(maxh, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        for (int i = 0; i < verticalCuts.length - 1; i++) {
            maxw = Math.max(maxw, verticalCuts[i + 1] - verticalCuts[i]);
        }
        return (int) ((long) maxh * maxw % 1000000007);
    }

    public static void main(String[] args) {

        int[] horizontalCuts = {1, 2, 4};
        int[] verticalCuts = {1, 3};
        System.out.println(maxArea(5, 4, horizontalCuts, verticalCuts));
    }
}
