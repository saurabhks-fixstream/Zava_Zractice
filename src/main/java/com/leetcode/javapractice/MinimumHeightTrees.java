package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<Set<Integer>> adj = new ArrayList<Set<Integer>>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<Integer>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; ++i) {
            if (adj.get(i).size() == 1) {
                result.add(i);
            }
        }
        while (n > 2) {
            n -= result.size();
            List<Integer> newResult = new ArrayList<Integer>();
            for (int i : result) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) {
                    newResult.add(j);
                }
            }
            result = newResult;
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        System.out.println(findMinHeightTrees(4, edges));
    }
}
