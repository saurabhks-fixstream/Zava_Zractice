package com.leetcode.javapractice;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        floodFillHelper(image, image.length, image[0].length, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void floodFillHelper(int[][] image, int m, int n, int sr, int sc, int color, int newColor) {
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != color) {
            return;
        }
        image[sr][sc] = newColor;
        floodFillHelper(image, m, n, sr - 1, sc, color, newColor);
        floodFillHelper(image, m, n, sr + 1, sc, color, newColor);
        floodFillHelper(image, m, n, sr, sc - 1, color, newColor);
        floodFillHelper(image, m, n, sr, sc + 1, color, newColor);
    }

    public static void main(String[] args) {

        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        floodFill(image, 1, 1, 2);
        for (int[] i : image) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }

}
