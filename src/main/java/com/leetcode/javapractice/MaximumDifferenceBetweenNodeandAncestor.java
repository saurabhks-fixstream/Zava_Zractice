package com.leetcode.javapractice;

public class MaximumDifferenceBetweenNodeandAncestor {

    public static int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public static int dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println(maxAncestorDiff(root));
    }
}
