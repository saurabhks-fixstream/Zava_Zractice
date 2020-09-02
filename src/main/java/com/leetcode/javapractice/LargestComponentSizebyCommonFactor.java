package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

class UnionFind {

    int[] parent;
    int[] size;
    int max;

    public UnionFind(int N) {
        parent = new int[N];
        size = new int[N];
        max = 1;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX];
            max = Math.max(max, size[rootY]);
        }
    }
}

public class LargestComponentSizebyCommonFactor {

    public static int largestComponentSize(int[] A) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        UnionFind uf = new UnionFind(A.length);
        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            for (int j = 2; j * j <= a; j++) {
                if (a % j == 0) {
                    if (!map.containsKey(j)) {
                        map.put(j, i);
                    } else {
                        uf.union(i, map.get(j));
                    }
                    if (!map.containsKey(a / j)) {
                        map.put(a / j, i);
                    } else {
                        uf.union(i, map.get(a / j));
                    }
                }
            }
            if (!map.containsKey(a)) {
                map.put(a, i);
            } else {
                uf.union(i, map.get(a));
            }
        }
        return uf.max;
    }

    public static void main(String[] args) {

        int[] A = {4, 6, 15, 35};
        System.out.println(largestComponentSize(A));
    }
}
