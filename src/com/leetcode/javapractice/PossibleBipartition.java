package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PossibleBipartition {

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }
        Map<Integer, Integer> color = new HashMap<Integer, Integer>();
        for (int i = 1; i <= N; i++) {
            if (!color.containsKey(i) && !dfs(graph, color, i, 0)) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(ArrayList<Integer>[] graph, Map<Integer, Integer> color, int node, int c) {
        if (color.containsKey(node)) {
            return color.get(node) == c;
        }
        color.put(node, c);
        for (int nei : graph[node]) {
            if (!dfs(graph, color, nei, c ^ 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] dislikes = { { 1, 2 }, { 1, 3 }, { 2, 4 } };
        System.out.println(possibleBipartition(4, dislikes));

    }

}
