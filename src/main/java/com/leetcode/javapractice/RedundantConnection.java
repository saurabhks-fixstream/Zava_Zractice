package com.leetcode.javapractice;

class DisjointSet {

    private int[] parent;
    private byte[] rank;

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new byte[n];
    }

    public int find(int x) {
        if (parent[x] == 0) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return false;
        }
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
            rank[rootY]++;
        }
        return true;
    }
}

public class RedundantConnection {

    public static int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        DisjointSet disjointSet = new DisjointSet(edges.length);
        for (int[] edge : edges) {
            if (!disjointSet.union(edge[0] - 1, edge[1] - 1)) {
                result = edge;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] result = findRedundantConnection(edges);
        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
