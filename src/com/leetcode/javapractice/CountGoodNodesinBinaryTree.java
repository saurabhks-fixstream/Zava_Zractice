package com.leetcode.javapractice;

public class CountGoodNodesinBinaryTree {

    static int count;

    public static int goodNodes(TreeNode root) {
        count = 0;
        goodNodesHelper(root, Integer.MIN_VALUE);
        return count;
    }

    private static void goodNodesHelper(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            count++;
        }
        goodNodesHelper(root.left, Math.max(root.val, max));
        goodNodesHelper(root.right, Math.max(root.val, max));
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println(goodNodes(root));

    }

}
