package com.leetcode.javapractice;

import java.util.HashMap;
import java.util.Map;

public class CloneNaryTree {

    public static Node cloneTree(Node root) {
        return clone(root, new HashMap<Node, Node>());
    }

    private static Node clone(Node node, Map<Node, Node> map) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for (Node child : node.children) {
            newNode.children.add(clone(child, map));
        }
        return newNode;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node node3 = new Node(3);
        node3.children.add(new Node(5));
        node3.children.add(new Node(6));
        root.children.add(node3);
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        System.out.println(NaryTreeLevelOrderTraversal.levelOrder(cloneTree(root)));
    }
}
