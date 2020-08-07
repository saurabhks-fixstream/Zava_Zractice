package com.leetcode.javapractice;

public class CheckIfItIsaStraightLine {

    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }
        int dx = coordinates[1][0] - coordinates[0][0];
        int dy = coordinates[1][1] - coordinates[0][1];
        for (int[] coordinate : coordinates) {
            if (dx * (coordinate[1] - coordinates[1][1]) != dy * (coordinate[0] - coordinates[1][0])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        System.out.println(checkStraightLine(coordinates));

    }

}
