package com.leetcode.javapractice;

public class SmallestSubtreewithalltheDeepestNodes {

    private static int deepest = 0;
    private static TreeNode lca;

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        subtreeWithAllDeepestHelper(root, 0);
        return lca;
    }

    private static int subtreeWithAllDeepestHelper(TreeNode node, int depth) {
        deepest = Math.max(deepest, depth);
        if (node == null) {
            return depth;
        }
        int left = subtreeWithAllDeepestHelper(node.left, depth + 1);
        int right = subtreeWithAllDeepestHelper(node.right, depth + 1);
        if (left == deepest && right == deepest) {
            lca = node;
        }
        return Math.max(left, right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(subtreeWithAllDeepest(root).val);
    }
}
