package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriticalConnectionsinaNetwork {

    static int time;

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        time = 0;
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (List<Integer> connection : connections) {
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
        boolean[] visited = new boolean[n];
        int[] ids = new int[n];
        int[] low = new int[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, -1, visited, ids, low, result);
            }
        }
        return result;
    }

    private static void dfs(
            Map<Integer, List<Integer>> graph,
            int curr,
            int parent,
            boolean[] visited,
            int[] ids,
            int[] low,
            List<List<Integer>> result) {
        visited[curr] = true;
        ++time;
        ids[curr] = time;
        low[curr] = time;
        for (int neighbour : graph.get(curr)) {
            if (neighbour == parent) {
                continue;
            }
            if (!visited[neighbour]) {
                dfs(graph, neighbour, curr, visited, ids, low, result);
                low[curr] = Math.min(low[curr], low[neighbour]);
                if (ids[curr] < low[neighbour]) {
                    result.add(Arrays.asList(curr, neighbour));
                }
            } else {
                low[curr] = Math.min(low[curr], ids[neighbour]);
            }
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> connections = new ArrayList<List<Integer>>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        System.out.println(criticalConnections(4, connections));
    }
}
