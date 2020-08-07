package com.leetcode.javapractice;

import java.util.Iterator;
import java.util.List;

public class GraphNode {

    int val;
    List<GraphNode> neighbors;

    GraphNode() {}

    GraphNode(int val, List<GraphNode> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public void dfs(GraphNode node, int v) {
        boolean[] visited = new boolean[v];
        dfsUtil(node, visited);
    }

    private void dfsUtil(GraphNode node, boolean[] visited) {
        visited[node.val] = true;
        System.out.print(node.val + " ");
        Iterator<GraphNode> i = node.neighbors.iterator();
        while (i.hasNext()) {
            GraphNode n = i.next();
            if (!visited[n.val]) {
                dfsUtil(n, visited);
            }
        }
    }
}
