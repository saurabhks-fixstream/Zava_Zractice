package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, i, visited, visiting)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(
            List<Integer>[] graph, int course, boolean[] visited, boolean[] visiting) {
        if (visiting[course]) {
            return true;
        }
        if (visited[course]) {
            return false;
        }
        visited[course] = true;
        visiting[course] = true;
        for (int neighbour : graph[course]) {
            if (dfs(graph, neighbour, visited, visiting)) {
                return true;
            }
        }
        visiting[course] = false;
        return false;
    }

    public static void main(String[] args) {

        int[][] prerequisites = {{1, 0}};
        System.out.println(canFinish(2, prerequisites));
    }
}
