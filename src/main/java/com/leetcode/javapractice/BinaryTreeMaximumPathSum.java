package com.leetcode.javapractice;

public class BinaryTreeMaximumPathSum {

    private static int max;

    public static int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return max;
    }

    private static int maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(0, maxPathSumHelper(root.left));
        int r = Math.max(0, maxPathSumHelper(root.right));
        max = Math.max(max, root.val + l + r);
        return root.val + Math.max(l, r);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }
}
