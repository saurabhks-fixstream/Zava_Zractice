package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (graph == null || graph.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        allPathsSourceTargetHelper(graph, 0, list, result);
        return result;
    }

    private static void allPathsSourceTargetHelper(int[][] graph, int node, List<Integer> list,
                                                   List<List<Integer>> result) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int c : graph[node]) {
            list.add(c);
            allPathsSourceTargetHelper(graph, c, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
        System.out.println(allPathsSourceTarget(graph));

    }

}
