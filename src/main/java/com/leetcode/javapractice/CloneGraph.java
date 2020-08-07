package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

    public static GraphNode cloneGraph(GraphNode node) {
        return clone(node, new HashMap<Integer, GraphNode>());
    }

    private static GraphNode clone(GraphNode node, Map<Integer, GraphNode> map) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        GraphNode newNode = new GraphNode(node.val, new ArrayList<GraphNode>());
        map.put(node.val, newNode);
        for (GraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor, map));
        }
        return newNode;
    }

    public static void main(String[] args) {

        GraphNode node1 = new GraphNode(1, null);
        GraphNode node2 = new GraphNode(2, null);
        GraphNode node3 = new GraphNode(3, null);
        GraphNode node4 = new GraphNode(4, null);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        GraphNode clone = cloneGraph(node1);
        clone.dfs(clone, 5);
    }
}
