package com.leetcode.javapractice;

public class TheMaze {

    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return hasPathHelper(maze, visited, start[0], start[1], destination, dirs);
    }

    private static boolean hasPathHelper(
            int[][] maze, boolean[][] visited, int x, int y, int[] destination, int[][] dirs) {
        if (visited[x][y]) {
            return false;
        }
        if (x == destination[0] && y == destination[1]) {
            return true;
        }
        visited[x][y] = true;
        for (int i = 0; i < dirs.length; i++) {
            int j = x;
            int k = y;
            while (isValid(maze, j + dirs[i][0], k + dirs[i][1])) {
                j += dirs[i][0];
                k += dirs[i][1];
            }
            if (hasPathHelper(maze, visited, j, k, destination, dirs)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1;
    }

    public static void main(String[] args) {

        int[][] maze = {
            {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] destination = {4, 4};
        System.out.println(hasPath(maze, start, destination));
    }
}
