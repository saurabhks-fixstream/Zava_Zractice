package com.leetcode.javapractice;

public class MaximumDepthofNaryTree {

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 1;
        for (Node node : root.children) {
            max = Math.max(max, maxDepth(node) + 1);
        }
        return max;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        Node c = new Node(3);
        c.children.add(new Node(5));
        c.children.add(new Node(6));
        root.children.add(c);
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        System.out.println(maxDepth(root));

    }

}
