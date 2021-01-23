package com.leetcode.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRootofNAryTree {

    public static Node findRoot(List<Node> tree) {
        if (tree == null || tree.size() == 0) {
            return null;
        }
        Set<Node> seen = new HashSet<Node>();
        for (Node node : tree) {
            for (Node child : node.children) {
                seen.add(child);
            }
        }
        for (Node node : tree) {
            if (!seen.contains(node)) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        List<Node> tree = new ArrayList<Node>();
        Node root = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(5);
        root.children.addAll(Arrays.asList(node3, node2, node4));
        node3.children.addAll(Arrays.asList(node5, node6));
        tree.addAll(Arrays.asList(node5, node4, root, node2, node3, node6, node4));
        System.out.println(findRoot(tree).val);
    }
}
