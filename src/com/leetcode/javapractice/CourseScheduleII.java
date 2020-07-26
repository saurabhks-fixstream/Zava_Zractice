package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph, i, visited, visiting, list)) {
                return new int[] {};
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = list.get(numCourses - i - 1);
        }
        return result;
    }

    private static boolean dfs(List<Integer>[] graph, int course, boolean[] visited, boolean[] visiting,
                               List<Integer> list) {
        if (visiting[course]) {
            return true;
        }
        if (visited[course]) {
            return false;
        }
        visited[course] = true;
        visiting[course] = true;
        for (int neighbour : graph[course]) {
            if (dfs(graph, neighbour, visited, visiting, list)) {
                return true;
            }
        }
        list.add(course);
        visiting[course] = false;
        return false;
    }

    public static void main(String[] args) {

        int[][] prerequisites = { { 1, 0 } };
        int[] result = findOrder(2, prerequisites);
        for (int r : result) {
            System.out.print(r + " ");
        }

    }

}
